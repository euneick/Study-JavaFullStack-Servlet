package sec03.ex01;

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
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("커넥션풀 생성 실패");
		}
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
	
	public ArrayList<MemberVO> getMembersList() {
		
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();

		try {
			String query = "select * from t_member";
			
			connection = dataSource.getConnection();			
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
	
	public boolean RegistMember(MemberVO memberVO) {

		boolean result = false;
		String query = "insert into t_member(id, pwd, name, email) values(?, ?, ?, ?)";

		try {
			connection = dataSource.getConnection();

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, memberVO.getId());
			preparedStatement.setString(2, memberVO.getPwd());
			preparedStatement.setString(3, memberVO.getName());
			preparedStatement.setString(4, memberVO.getEmail());
			
			// PreparedStatement.executeQuery() 메소드는 select 구문만 실행
			// 나머지는 모두 executeUpdate() 메소드로 실행
			result = preparedStatement.executeUpdate() == 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return result;
	}
}


