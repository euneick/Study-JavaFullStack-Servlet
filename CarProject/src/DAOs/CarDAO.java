package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import VOs.CarConfirmVO;
import VOs.CarListVO;
import VOs.CarOrderVO;

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
	
	public int insertCarOrder(CarOrderVO carOrderVO, HttpSession session) {
		
		int result = 0;

		String id = (String) session.getAttribute("id");
		
		try {
			connection = dataSource.getConnection();

			String sql = "";
			
			if (id == null) {
				sql = "insert into non_carorder(non_orderid, carno, carqty, carreserveday, "
						+ "carbegindate, carins, carwifi, carnave, carbabyseat, memberphone, memberpass)"
						+ "values(non_carorder_non_orderid.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				statement = connection.prepareStatement(sql);
				statement.setInt(1, carOrderVO.getCarno());
				statement.setInt(2, carOrderVO.getCarqty());
				statement.setInt(3, carOrderVO.getCarreserveday());
				statement.setString(4, carOrderVO.getCarbegindate());
				statement.setInt(5, carOrderVO.getCarins());
				statement.setInt(6, carOrderVO.getCarwifi());
				statement.setInt(7, carOrderVO.getCarnave());
				statement.setInt(8, carOrderVO.getCarbabyseat());
				statement.setString(9, carOrderVO.getMemberphone());
				statement.setString(10, carOrderVO.getMemberpass());
			}
			else {
				
			}
			
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
	
	public Vector<CarConfirmVO> selectCarConfirms(String memberphone, String memberpass) {
		
		Vector<CarConfirmVO> carConfirmList = new Vector<CarConfirmVO>();
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from non_carorder natural join carlist "
					+ "where sysdate < to_date(carbegindate, 'yyyy-mm-dd') and "
					+ "memberphone=? and memberpass=?";
			
			statement = connection.prepareStatement(sql);			
			statement.setString(1, memberphone);
			statement.setString(2, memberpass);
			
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				CarConfirmVO carConfirm = new CarConfirmVO(
						resultSet.getString("carname"),
						resultSet.getString("carimg"),
						resultSet.getInt("carprice"),
						resultSet.getInt("non_orderid"),
						resultSet.getInt("carreserveday"),
						resultSet.getInt("carqty"),
						resultSet.getInt("carins"),
						resultSet.getInt("carwifi"),
						resultSet.getInt("carnave"),
						resultSet.getInt("carbabyseat"),
						resultSet.getString("carbegindate"));
				
				carConfirmList.add(carConfirm);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패");
		}
		finally {
			Release();
		}
		
		return carConfirmList;
	}
	
	public CarConfirmVO selectCarConfirm(int orderId) {
		
		CarConfirmVO carConfirmVO = null;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from non_carorder where non_orderid=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderId);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				carConfirmVO = new CarConfirmVO();
				
				carConfirmVO.setOrderid(resultSet.getInt("non_orderid"));
				carConfirmVO.setCarbegindate(resultSet.getString("carbegindate"));
				carConfirmVO.setCarreserveday(resultSet.getInt("carreserveday"));
				carConfirmVO.setCarins(resultSet.getInt("carins"));
				carConfirmVO.setCarwifi(resultSet.getInt("carwifi"));
				carConfirmVO.setCarnave(resultSet.getInt("carnave"));
				carConfirmVO.setCarbabyseat(resultSet.getInt("carbabyseat"));
				carConfirmVO.setCarqty(resultSet.getInt("carqty"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 조회 실패 ");
		}
		finally {
			Release();
		}
		
		return carConfirmVO;
	}
	
	public int updateCarOrder(HttpServletRequest request) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "update non_carorder "
					+ "set carbegindate=?, carreserveday=?, carins=?, carwifi=?, carnave=?, carbabyseat=?, carqty=? "
					+ "where non_orderid=? and memberpass=?";
			statement = connection.prepareStatement(sql);
			
			int index = 1;
			statement.setString(index++, request.getParameter("carbegindate"));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carreserveday")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carins")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carwifi")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carnave")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carbabyseat")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("carqty")));
			statement.setInt(index++, Integer.parseInt(request.getParameter("orderid")));
			statement.setString(index++, request.getParameter("memberpass"));
			
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
	
	public int deleteCarOrder(int orderid, String memberpass) {
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			
			String sql = "delete from non_carorder where non_orderid=? and memberpass=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, orderid);
			statement.setString(2, memberpass);
			
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





























