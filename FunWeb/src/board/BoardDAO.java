package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {

	private DataSource dataSource; 			// 커넥션 풀
	private Connection connection; 			// 커넥션 풀에 만들어진 커넥션 중 하나를 저장
	private PreparedStatement statement; 	// DB에 쿼리문을 전송
	private ResultSet resultSet; 			// select 결과를 저장

	public BoardDAO() {

		try {
			Context initContext = new InitialContext();
			Context context = (Context) initContext.lookup("java:comp/env");
			dataSource = (DataSource) context.lookup("jdbc/funweb");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
	public Vector<Object> getBoardList(String keyField, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(BoardBean boardBean) {

		try {
			connection = dataSource.getConnection();
			
			statement = connection.prepareStatement("insert into board(name, pwd, subject, content, ip, join_date, id)"
					+ " values (?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, boardBean.getName());
			statement.setString(2, boardBean.getPwd());
			statement.setString(3, boardBean.getSubject());
			statement.setString(4, boardBean.getContent());
			statement.setString(5, boardBean.getIp());
			statement.setTimestamp(6, boardBean.getJoinDate());
			statement.setString(7, boardBean.getId());
			
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
	}

	@Override
	public void updateBoard(BoardBean boardBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int num, String id, String pwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replyBoard(BoardBean beanBoardBean) {
		// TODO Auto-generated method stub

	}
}
