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
	
	public ArrayList<BoardVO> selectSearchedBoards(String key, String word) {
				
		if (word.equals("")) return selectBoards();

		String sql = "";
		
		if (key.equals("titleContent"))
			sql = "select * from board "
					+ "where b_title like '%" + word + "%' "
					+ "or b_content like '%" + word + "%' order by b_group asc";
		else if (key.equals("name"))
			sql = "select * from board "
					+ "where b_name like '%" + word + "%' order by b_group asc";

		ArrayList<BoardVO> boards = new ArrayList<BoardVO>();
		
		try {
			connection = dataSource.getConnection();			
			
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
	
	public int insertBoard(BoardVO board) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update board set b_group=b_group+1";
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			
			sql = "insert into board(b_idx, b_id, b_pw, b_name, b_email, "
					+ "b_title, b_content, b_group, b_level, b_date, b_cnt) "
					+ "values(border_b_idx.nextval, ?, ?, ?, ?, ?, ?, 0, 0, sysdate, 0)";
			statement = connection.prepareStatement(sql);
			int index = 1;
			statement.setString(index++, board.getId());
			statement.setString(index++, board.getPw());
			statement.setString(index++, board.getName());
			statement.setString(index++, board.getEmail());
			statement.setString(index++, board.getTitle());
			statement.setString(index++, board.getContent());
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 추가 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
	
	public int insertReplyBoard(String parentIdx, BoardVO board) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			/*
			String sql ="select * from board where b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(parentIdx));
			
			resultSet = statement.executeQuery();
			
			if (!resultSet.next()) return 0;			
			
			sql = "update board set b_group = b_group + 1 where b_group > ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, resultSet.getInt("b_group"));
			
			statement.executeUpdate();
			
			sql = "insert into board(b_idx, b_id, b_pw, b_name, b_email, "
					+ "b_title, b_content, b_group, b_level, b_date, b_cnt) "
					+ "values(border_b_idx.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, 0)";
			statement = connection.prepareStatement(sql);
			int index = 1;
			statement.setString(index++, board.getId());
			statement.setString(index++, board.getPw());
			statement.setString(index++, board.getName());
			statement.setString(index++, board.getEmail());
			statement.setString(index++, board.getTitle());
			statement.setString(index++, board.getContent());
			statement.setInt(index++, resultSet.getInt("b_group") + 1);
			statement.setInt(index++, resultSet.getInt("b_level") + 1);			
			*/
			/*
			String sql = 
					"BEGIN " 
						+ "UPDATE board SET b_group = b_group + 1 "
						+ "WHERE b_group > (SELECT b_group FROM board WHERE b_idx = ?); "
				
						+ "INSERT INTO board(b_idx, b_id, b_pw, b_name, b_email, b_title, b_content, "
							+ "b_group, b_level, b_date, b_cnt) "
							+ "VALUES(border_b_idx.nextval, ?, ?, ?, ?, ?, ?, "
							+ "(SELECT b_group + 1 FROM board WHERE b_idx = ?), "
							+ "(SELECT b_level + 1 FROM board WHERE b_idx = ?), SYSDATE, 0); "
					+ "END;";
			*/
			
			String sql = "DECLARE \r\n" + 
					"    parent_group NUMBER; \r\n" + 
					"    parent_level NUMBER; \r\n" + 
					"    BEGIN \r\n" + 
					"        SELECT b_group, b_level \r\n" + 
					"        INTO parent_group, parent_level \r\n" + 
					"        FROM board \r\n" + 
					"        WHERE b_idx = ?;\r\n" + 
					"    \r\n" + 
					"        UPDATE board \r\n" + 
					"        SET b_group = b_group + 1 \r\n" + 
					"        WHERE b_group > parent_group; \r\n" + 
					"    \r\n" + 
					"        INSERT INTO board ( \r\n" + 
					"            b_idx, b_id, b_pw, b_name, b_email, b_title, b_content, \r\n" + 
					"            b_group, b_level, b_date, b_cnt\r\n" + 
					"        ) VALUES (\r\n" + 
					"            border_b_idx.nextval, ?, ?, ?, ?, ?, ?, \r\n" + 
					"            parent_group + 1, parent_level + 1, SYSDATE, 0\r\n" + 
					"        );\r\n" + 
					"        \r\n" + 
					"        COMMIT;\r\n" + 
					"    END;";
			statement = connection.prepareStatement(sql);			
			int index = 1;
			statement.setInt(index++, Integer.parseInt(parentIdx));
			statement.setString(index++, board.getId());
			statement.setString(index++, board.getPw());
			statement.setString(index++, board.getName());
			statement.setString(index++, board.getEmail());
			statement.setString(index++, board.getTitle());
			statement.setString(index++, board.getContent());
			
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
	
	public BoardVO selectBoard(String idx) {
		
		BoardVO board = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from board where b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				board = new BoardVO(
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
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}
		return board;
	}
	
	public boolean checkBoardPassword(String idx, String password) {
		
		boolean result = false;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from board where b_idx=? and b_pw=? order by b_group asc";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			statement.setString(2, password);
			
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
	
	public int updateBoard(String idx, String email, String title, String content) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update board set b_email=?, b_title=?, b_content=? where b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, title);
			statement.setString(3, content);
			statement.setInt(4, Integer.parseInt(idx));
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 수정 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
	
	public int deleteBoard(String idx) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "delete from board where b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 삭제 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
}
