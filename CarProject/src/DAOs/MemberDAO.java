package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/oracle");
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
	
	public boolean checkJoinId(String id) {
		
		boolean result = false;
		
		try {
			connection = dataSource.getConnection();

			// 오라클에 내장된 decode 함수 
			// 	- 1번째 파라미터의 결과가 2번째 파라미터와 같다면 3번째, 아니면 4번째 파라미터를 반환하는 함수 (조건식과 같음, else if 처럼 추가 가능)
//			String sql = "select decode(count(*), 1, 'true', 'false') as result "
//					+ "from member where id=?";
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, id);
			
			String sql = "select id from member where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			
			result = resultSet.next();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
	
	public int insertMember() {
		
		int result = 0;
		
		return result;
	}
}





























