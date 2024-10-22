package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource dataSource;
	
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public MemberDAO() {
		
		try {
			Context context = (Context) new InitialContext().lookup("java:/comp/env");
			dataSource = (DataSource) context.lookup("jdbc/oracle");
		}
		catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
	}
	
	private void Release() {
		
		try {
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connection != null) connection.close();
		}
		catch (Exception e) {
			System.out.println("자원 해제 실패");
			e.printStackTrace();
		}
	}

	public ArrayList<MemberVO> getMembersList() {
		
		ArrayList<MemberVO> membersList = new ArrayList<MemberVO>();
		
		try {
			connection = dataSource.getConnection();		// context.xml에서 생성된 커넥션 풀에서 커넥션 받아오기
			
			String sql = "select * from t_member order by joinDate desc";
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				MemberVO memberVO = new MemberVO(
						resultSet.getString("id"), 
						resultSet.getString("pwd"), 
						resultSet.getString("name"), 
						resultSet.getString("email"), 
						resultSet.getDate("joinDate"));
				
				membersList.add(memberVO);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return membersList;
	}
}






























