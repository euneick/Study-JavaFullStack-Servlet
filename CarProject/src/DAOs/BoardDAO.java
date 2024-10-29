package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VOs.BoardVO;

public class BoardDAO {

	private DataSource dataSource;
	
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public BoardDAO() {

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
	
	public ArrayList<BoardVO> selectBoards() {
		
		ArrayList<BoardVO> boards = new ArrayList<BoardVO>();
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from board order by b_group asc";
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				BoardVO board = new BoardVO(
						resultSet.getInt("b_idx"),
						resultSet.getString("b_id"),
						resultSet.getString("b_pw"),
						resultSet.getString("b_name"),
						resultSet.getString("b_email"),
						resultSet.getString("b_title"),
						resultSet.getString("b_content"),
						resultSet.getInt("b_group"),
						resultSet.getInt("b_level"),
						resultSet.getDate("b_date"),
						resultSet.getInt("b_cnt"));
				
				boards.add(board);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}
		
		return boards;
	}
}
