package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOs.CarDAO;
import VOs.CarConfirmVO;
import VOs.CarListVO;
import VOs.CarOrderVO;

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
		else if (action.equals("/CarOption.do")) { openCarOptionPage(request, response); }
		else if (action.equals("/CarOptionResult.do")) { openCarOptionResultPage(request, response); }
		else if (action.equals("/CarOrder.do")) { processCarOrderData(request, response); return; }
		else if (action.equals("/ReserveConfirm")) { openReserveConfirmPage(request, response); }
		else if (action.equals("/CarReserveConfirm.do")) { openReserveResultPage(request, response); }
		
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
	
	private void openCarOptionPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("center", "CarOption.jsp");
		nextPage = "/CarMain.jsp";
	}
	
	private CarOrderVO parseCarOrderVO(HttpServletRequest request) {
		
		int carno = Integer.parseInt(request.getParameter("carno"));
		String carbegindate = request.getParameter("carbegindate");
		int carqty = Integer.parseInt(request.getParameter("carqty"));
		int carreserveday = Integer.parseInt(request.getParameter("carreserveday"));
		int carins = Integer.parseInt(request.getParameter("carins"));
		int carwifi = Integer.parseInt(request.getParameter("carwifi"));
		int carnave = Integer.parseInt(request.getParameter("carnave"));
		int carbabyseat = Integer.parseInt(request.getParameter("carbabyseat"));
		
		CarOrderVO carOrderVO = new CarOrderVO(
				carno, carqty, carreserveday, carbegindate, 
				carins, carwifi, carnave, carbabyseat);
		
		return carOrderVO;
	}
	
	private void openCarOptionResultPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CarOrderVO carOrderVO = parseCarOrderVO(request);
		int carprice = Integer.parseInt(request.getParameter("carprice"));

		int totalReserve = carprice * carOrderVO.getCarqty() * carOrderVO.getCarreserveday();		
		int totalOption = (carOrderVO.getCarins() + carOrderVO.getCarwifi() + carOrderVO.getCarbabyseat())
				* carOrderVO.getCarreserveday() * carOrderVO.getCarqty() * 10000;
		
		request.setAttribute("carOrder", carOrderVO);
		request.setAttribute("totalReserve", totalReserve);
		request.setAttribute("totalOption", totalOption);

		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			request.setAttribute("center", "CarOrder.jsp");
		}
		else {
			request.setAttribute("center", "LoginCarOrder.jsp");
		}

		nextPage = "/CarMain.jsp";
	}
	
	private void processCarOrderData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CarOrderVO carOrderVO = parseCarOrderVO(request);
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			String memberphone = request.getParameter("memberphone");
			String memberpass = request.getParameter("memberpass");
			
			carOrderVO.setMemberphone(memberphone);
			carOrderVO.setMemberpass(memberpass);
		}
		else {
			String memberid = request.getParameter("memberid");
			String memberpass = request.getParameter("memberpass");
			
			carOrderVO.setId(memberid);
			carOrderVO.setMemberpass(memberpass);
		}
		
		int result = carDAO.insertCarOrder(carOrderVO, session);
		String message = result == 1 ? "예약되었습니다." : "예약에 실패했습니다.";
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<script>");
		printWriter.print("alert('" + message + "');");
		printWriter.print("location.href = '" + request.getContextPath() + "/Car/CarList.do';");
		printWriter.print("</script>");
	}
	
	private void openReserveConfirmPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		request.setAttribute("center", request.getParameter("center"));
		nextPage = "/CarMain.jsp";
	}
	
	private void openReserveResultPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		Vector<CarConfirmVO> carConfirmList = carDAO.selectCarConfirms(memberphone, memberpass);
		
		request.setAttribute("carConfirmList", carConfirmList);
		request.setAttribute("memberphone", memberphone);
		request.setAttribute("memberpass", memberpass);

		request.setAttribute("center", "CarReserveResult.jsp");
		nextPage = "/CarMain.jsp";
	}
}