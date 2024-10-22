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
			Context context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/oracle");
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
			System.out.println("데이터 조회 실패");
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return membersList;
	}
	
	public MemberVO selectMember(String id) {
		
		MemberVO member = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from t_member where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			resultSet = statement.executeQuery();
			resultSet.next();
			
			member = new MemberVO(
					resultSet.getString("id"), 
					resultSet.getString("pwd"), 
					resultSet.getString("name"), 
					resultSet.getString("email"), 
					resultSet.getDate("joinDate"));
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB " + id + " 조회 실패");
		}
		finally {
			Release();
		}
		
		return member;
	}
	
	public int insertMember(MemberVO memberVO) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "insert into t_member(id, pwd, name, email) values (?, ?, ?, ?)";			
			statement = connection.prepareStatement(sql);
			statement.setString(1, memberVO.getId());
			statement.setString(2, memberVO.getPwd());
			statement.setString(3, memberVO.getName());
			statement.setString(4, memberVO.getEmail());
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("데이터 추가 실패");
			e.printStackTrace();
		}
		finally {
			Release();
		}
		
		return result;
	}
	
	public int updateMember(MemberVO memberVO) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update t_member set name=?, email=? where id=?";
			statement = connection.prepareStatement(sql);			
			statement.setString(1, memberVO.getName());
			statement.setString(2, memberVO.getEmail());
			statement.setString(3, memberVO.getId());
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 수정 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
	
	public int deleteMember(String id) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "delete from t_member where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			
			result = statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터 삭제 실패");
		}
		finally {
			Release();
		}
		
		return result;
	}
}






























