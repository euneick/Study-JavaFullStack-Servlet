package Controllers;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOs.CarDAO;
import VOs.CarListVO;

@WebServlet("/Car/*")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CarDAO carDAO;
	
	private String nextPage;

	public void init(ServletConfig config) throws ServletException {

		carDAO = new CarDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		if (action.equals("/Main")) { nextPage = "/CarMain.jsp"; }
		else if (action.equals("/Reservation")) { openReservationPage(request, response); }
		else if (action.equals("/CarList.do") || action.equals("/CarCategory.do")) { openCarCategoryPage(request, response); }
		else if (action.equals("/CarInfo.do")) { openCarInfoPage(request, response); }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	private void openReservationPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String center = request.getParameter("center");
		
		request.setAttribute("center", center);

		nextPage = "/CarMain.jsp";
	}
	
	private void openCarCategoryPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("carcategory");

		Vector<CarListVO> carVector = carDAO.selectCarLists(category);

		request.setAttribute("carVector", carVector);
		request.setAttribute("center", "CarList.jsp");
		
		nextPage = "/CarMain.jsp";
	}
	
	private void openCarInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int carNo = Integer.parseInt(request.getParameter("carno"));
		
		CarListVO car = carDAO.selectCarList(carNo);
		
		request.setAttribute("carInfo", car);
		request.setAttribute("center", "CarInfo.jsp");
		
		nextPage = "/CarMain.jsp";
	}
}
