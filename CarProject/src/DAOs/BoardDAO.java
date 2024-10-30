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
			
			String sql = "select * from board order by b_idx desc";
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
					+ "or b_content like '%" + word + "%' order by b_idx desc";
		else if (key.equals("name"))
			sql = "select * from board "
					+ "where b_name like '%" + word + "%' order by b_idx desc";

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
			
			String sql = "insert into board(b_idx, b_id, b_pw, b_name, b_email, "
					+ "b_title, b_content, b_group, b_level, b_date, b_cnt) "
					+ "values(border_b_idx.nextval, ?, ?, ?, ?, ?, ?, 1, 0, sysdate, 0)";
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
}
