package sec02.ex01;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 	DAO (Database Access Object) 클래스
 * 		- DB의 table과 연결하여 쿼리문을 주고 받는 클래스 
 */
public class MemberDAO {
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private DataSource dataSource;
	
	public MemberDAO() {
	
		try {
			// JNDI에 접근하기 위해 기본경로 ("java:/comp/env") 지정
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");		// lookup(String name) 메소드 - name에 대응하는 객체 찾기
			
			// context.xml에 작성한 name 속성값을 이용해 톰캣이 미리 연결한 DataSource를 받음
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션풀 생성 실패");
		}
	}
	
	public ArrayList<MemberVO> getMembersList() {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		try {
			// 커넥션풀을 이용해 데이터베이스 연결
			connection = dataSource.getConnection();

			String query = "select * from t_member";
			System.out.println("query : " + query);
			
			preparedStatement = connection.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(resultSet.getString("id"));
				memberVO.setPwd(resultSet.getString("pwd"));
				memberVO.setName(resultSet.getString("name"));
				memberVO.setEmail(resultSet.getString("email"));
				memberVO.setJoinDate(resultSet.getDate("joinDate"));

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
