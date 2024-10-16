package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO implements IMemberDAO{
	
	private DataSource dataSource;			// 커넥션 풀
	private Connection connection;			// 커넥션 풀에 만들어진 커넥션 중 하나를 저장
	private PreparedStatement statement;	// DB에 쿼리문을 전송
	private ResultSet resultSet;			// select 결과를 저장
	
	/**
	 * 	커넥션 풀(DataSource) 및 커넥션(Connection) 객체를 얻고 커넥션 자체를 반환<br>
	 * 		Context<br>
	 * 			- JNDI에서 이름과 실제 객체를 연결하는 개념<br>
	 * 		InitialContext<br>
	 * 			- JNDI를 이용하기 위한 시작점<br>
	 * 		"java:comp/env"<br>
	 * 			- 현재 Web Application의 root directory<br>
	 * 			- 현재 Web Application이 사용 할 수 있는 위치는 "java:comp/env" 아래에 위치함 <br>
	 * 			- context.xml 파일 내 context 태그 위치를 뜻함
	 */
	private Connection getConnection() throws Exception {
		
		Context initContext = new InitialContext();
		
		Context context = (Context) initContext.lookup("java:comp/env");
		
		// context 태그 내에 name 속성 값이 "jdbc/funweb" 인 Resource를 lookup
		dataSource = (DataSource) context.lookup("jdbc/funweb");
		
		connection = dataSource.getConnection();
		
		return connection;
	}
	
	private void Release() {
		
		try {
			if (resultSet != null) resultSet.close();
			if (statement != null) statement.close();
			if (connection != null) connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int validateID(String id) {

		int result = 0;			//  1 : 중복		0 : 중복 아님
		
		try {			
			connection = getConnection();
			
			statement = connection.prepareStatement("select * from member where id=?");
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			
			result = resultSet.next() ? 1 : 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return result;
	}

	@Override
	public int insertMember(MemberBean memberBean) {

		int result = 0;
		
		try {			
			connection = getConnection();
			
			statement = connection.prepareStatement("insert into member(id, pwd, name, join_date, email, address, tel, mtel)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, memberBean.getId());
			statement.setString(2, memberBean.getPwd());
			statement.setString(3, memberBean.getName());
			statement.setTimestamp(4, memberBean.getJoinDate());
			statement.setString(5, memberBean.getEmail());
			statement.setString(6, memberBean.getAddress());
			statement.setString(7, memberBean.getTel());
			statement.setString(8, memberBean.getMtel());
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return result;
	}

	@Override
	public int checkUser(String id, String pwd) {

		int result = 0;
		String sql = "";
		
		try {
			connection = getConnection();
			
			sql = "select id, pwd from member where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) result = pwd.equals(resultSet.getString("pwd")) ? 1 : 0;
			else result = 0;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return result;
	}

}
