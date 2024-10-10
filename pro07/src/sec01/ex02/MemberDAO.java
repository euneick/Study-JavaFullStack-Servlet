package sec01.ex02;

import java.sql.*;
import java.util.ArrayList;

/**
 * 	DAO (Database Access Object) 클래스
 * 		- DB의 table과 연결하여 쿼리문을 주고 받는 클래스 
 */
public class MemberDAO {
	
	// 오라클 DBMS에 접속하기 위한 정보들 작성
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";		// ojdbc6.jar 내 OracleDriver.class 경로
	private static final String URL = "jdbc:oracle:thin:@localhost:1522:XE";	// Oracle DBMS 주소
	private static final String USER = "euneick";								// 접속 id
	private static final String PWD = "1234";									// 접속 password

	// Oracle DB와 접속한 정보를 가지고 있는 객체
	private Connection connection;
	
	// SQL문을 Oracle DB에 전달하는 객체
	private PreparedStatement preparedStatement;
	
	// SELECT 쿼리문 실행 결과를 저장할 객체 (SELECT 구문만 가능)
	private ResultSet resultSet;
	
	private void connectDB() {
		
		try {
			// OracleDriver.class를 메모리에 동적으로 로딩
			Class.forName(DRIVER);
			
			// OracleDriver.class를 동적으로 로딩하면서 static으로 할당 된 DriverManager 클래스 사용
			connection = DriverManager.getConnection(URL, USER, PWD);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DRIVER 로딩 실패");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database Connection 실패");
		}
	}
	
	public ArrayList<MemberVO> getMembersList() {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		try {
			connectDB();

			String query = "select * from t_member";
			System.out.println("query : " + query);
			
			/*
			 * 쿼리문을 미리 준비해두고 필요 할 때만 executeQuery() 메소드를 통해 바로 실행 할 수 있음
			 * 매번 쿼리문을 새로 준비해야하는 Statement 객체보다 훨씬 안정적임
			 * 변수를 처리하거나 동일한 쿼리를 여러번 실행 할 때 유리
			 * 보안과 성능 측면에서 큰 이점을 제공
			 */
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				// 쿼리문 실행 결과가 담겨있는 resultSet객체의 정보를 각 변수에 저장
				String id = resultSet.getString("id");
				String pwd = resultSet.getString("pwd");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date joinDate = resultSet.getDate("joinDate");

				MemberVO memberVO = new MemberVO();
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				memberVO.setJoinDate(joinDate);

				memberList.add(memberVO);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리문 실행 실패");
		}
		finally {
			Release();
		}
		
		return memberList;
	}

	public void Release() {

		// 사용이 끝난 자원 해제
		try {
			if (resultSet != null) resultSet.close();
			if (preparedStatement != null) preparedStatement.close();
			if (connection != null) connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
