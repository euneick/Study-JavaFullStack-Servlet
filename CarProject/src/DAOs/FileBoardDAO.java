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
}
