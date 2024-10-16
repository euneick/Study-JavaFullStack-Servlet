package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private Connection getConnection() throws Exception{
		
		Context initContext = new InitialContext();
		
		Context context = (Context) initContext.lookup("java:comp/evn");
		
		// context 태그 내에 name 속성 값이 "jdbc/funweb" 인 Resource를 lookup
		dataSource = (DataSource) context.lookup("jdbc/funweb");
		
		connection = dataSource.getConnection();
		
		return connection;
	}

	@Override
	public int validateID(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkUser(String id, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
