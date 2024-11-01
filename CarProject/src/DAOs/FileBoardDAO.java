package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VOs.BoardVO;
import VOs.FileBoardVO;

public class FileBoardDAO {
	
	private DataSource dataSource;
	
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public FileBoardDAO() {

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
	
	public ArrayList<FileBoardVO> selectFileBoards() {
		
		ArrayList<FileBoardVO> boards = new ArrayList<FileBoardVO>();
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "SELECT * FROM fileboard ORDER BY b_group ASC";
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				FileBoardVO board = new FileBoardVO(
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
						resultSet.getInt("b_cnt"),
						resultSet.getString("ofile"),
						resultSet.getString("sfile"),
						resultSet.getInt("downcount"));
				
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
	
	public ArrayList<FileBoardVO> selectSearchedBoards(String key, String word) {
				
		if (word.equals("")) return selectFileBoards();

		String sql = "";
		
		if (key.equals("titleContent"))
			sql = "select * from fileboard "
					+ "where b_title like '%" + word + "%' "
					+ "or b_content like '%" + word + "%' order by b_group asc";
		else if (key.equals("name"))
			sql = "select * from fileboard "
					+ "where b_name like '%" + word + "%' order by b_group asc";

		ArrayList<FileBoardVO> boards = new ArrayList<FileBoardVO>();
		
		try {
			connection = dataSource.getConnection();			
			
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				FileBoardVO board = new FileBoardVO(
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
						resultSet.getInt("b_cnt"),
						resultSet.getString("ofile"),
						resultSet.getString("sfile"),
						resultSet.getInt("downcount"));
				
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
	
	public int getInsertedBoardIdx(FileBoardVO board) {
		
		int lastIdx = getLastIdx();
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update fileBoard set b_group=b_group+1";
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			
			sql = "insert into fileBoard(b_idx, b_id, b_pw, b_name, b_email, "
					+ "b_title, b_content, b_group, b_level, b_date, b_cnt, sfile, downcount) "
					+ "values(?, ?, ?, ?, ?, ?, ?, 0, 0, sysdate, 0, ?, 0)";
			statement = connection.prepareStatement(sql);
			int index = 1;
			statement.setInt(index++, lastIdx);
			statement.setString(index++, board.getId());
			statement.setString(index++, board.getPw());
			statement.setString(index++, board.getName());
			statement.setString(index++, board.getEmail());
			statement.setString(index++, board.getTitle());
			statement.setString(index++, board.getContent());
			statement.setString(index++, board.getSfile());
			
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 추가 실패");
		}
		finally {
			Release();
		}
		
		return lastIdx;
	}
	
	private int getLastIdx() {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select max(b_idx) as idx from fileboard";
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				result = resultSet.getInt("idx") + 1;
			}
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
	
	public FileBoardVO selectBoard(String idx) {
		
		FileBoardVO board = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "UPDATE fileboard SET b_cnt=b_cnt+1 WHERE b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			
			statement.executeUpdate();
			
			sql = "select * from fileboard where b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				board = new FileBoardVO(
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
						resultSet.getInt("b_cnt"),
						resultSet.getString("ofile"),
						resultSet.getString("sfile"),
						resultSet.getInt("downcount"));
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
	
	public void increaseBoardDownCount(String idx) {
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "UPDATE fileboard SET downcount=downcount+1 WHERE b_idx=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(idx));
			
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			Release();
		}
	}
}
