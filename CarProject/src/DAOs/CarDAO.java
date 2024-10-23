package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VOs.CarListVO;

public class CarDAO {
	
	private DataSource dataSource;
	
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;
	
	public CarDAO() {
		
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

	public Vector<CarListVO> selectCarLists(String category) {
		
		Vector<CarListVO> carList = new Vector<CarListVO>();
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from carlist";
			
			if(category != null) sql += " where carcategory='" + category + "'";
			
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				CarListVO car = new CarListVO(
						resultSet.getInt("carno"),
						resultSet.getString("carname"),
						resultSet.getString("carcompany"),
						resultSet.getInt("carprice"),
						resultSet.getInt("carusepeople"),
						resultSet.getString("carinfo"),
						resultSet.getString("carimg"),
						resultSet.getString("carcategory"));
				
				carList.add(car);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}
		
		return carList;
	}
	
	public CarListVO selectCarList(int carNo) {
		
		CarListVO car = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from carlist where carno=?";			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, carNo);
			
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				car = new CarListVO(
						resultSet.getInt("carno"),
						resultSet.getString("carname"),
						resultSet.getString("carcompany"),
						resultSet.getInt("carprice"),
						resultSet.getInt("carusepeople"),
						resultSet.getString("carinfo"),
						resultSet.getString("carimg"),
						resultSet.getString("carcategory"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}		
		
		return car;
	}
}
