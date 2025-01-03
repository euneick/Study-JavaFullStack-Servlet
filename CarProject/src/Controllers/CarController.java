package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.NaverSearchAPI;
import DAOs.CarDAO;
import VOs.CarConfirmVO;
import VOs.CarListVO;
import VOs.CarOrderVO;

@WebServlet("/Car/*")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter printWriter;
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
		
		printWriter = response.getWriter();

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
		else if (action.equals("/ReserveUpdate")) { openReserveUpdatePage(request, response); }
		else if (action.equals("/ReserveUpdate.do")) { processReserveUpdate(request, response); return; }		
		else if (action.equals("/ReserveDelete")) { openReserveDeletePage(request, response); }
		else if (action.equals("/ReserveDelete.do")) { processReserveDelete(request, response); return; }
		else if (action.equals("/NaverSearchAPI.do")) { processSearchAPI(request, response); }
		
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
	
	private void openReserveUpdatePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int orderId = Integer.parseInt(request.getParameter("orderid"));
		String carimg = request.getParameter("carimg");
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		CarConfirmVO carConfirm = carDAO.selectCarConfirm(orderId);
		carConfirm.setCarimg(carimg);
		
		request.setAttribute("carConfirm", carConfirm);
		request.setAttribute("memberphone", memberphone);
		request.setAttribute("memberpass", memberpass);
		
		request.setAttribute("center", "CarReserveUpdate.jsp");
		nextPage = "/CarMain.jsp";
	}
	
	private void processReserveUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result = carDAO.updateCarOrder(request);
		
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberphone = request.getParameter("memberphone");
		String carimg = request.getParameter("carimg");
		
		printWriter.print("<script>");
		printWriter.print("alert('" + (result == 1 ? "예약이 변경되었습니다." : "예약 변경에 실패했습니다.") + "');");
		printWriter.print(
					result == 1 ?
					"location.href = '" + request.getContextPath()
					+ "/Car/ReserveUpdate?orderid=" + orderid + "&carimg=" + carimg + "&memberphone=" + memberphone + "';" :
					"history.back();"
				);
		printWriter.print("</script>");
	}
	
	private void openReserveDeletePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("center", request.getParameter("center"));
		nextPage = "/CarMain.jsp";
	}

	private void processReserveDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String memberphone = request.getParameter("memberphone");
		String memberpass = request.getParameter("memberpass");
		
		int result = carDAO.deleteCarOrder(orderid, memberpass);

		printWriter.print("<script>");
		printWriter.print("alert('" + (result == 1 ? "예약이 삭제 되었습니다." : "예약 삭제에 실패했습니다.") + "');");
		if (result == 1)
			printWriter.printf("location.href='%s/Car/CarReserveConfirm.do?memberphone=%s&memberpass=%s';",
					request.getContextPath(), memberphone, memberpass);
		else
			printWriter.print("history.back();");
		printWriter.print("</script>");
	}
	
	private void processSearchAPI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* 인증정보 설정*/
		String clientId = "kx8sREeigxnmZSoSZfkp";
		String clientSecret = "yGhFctOkbk";
		
		/* 검색 조건 설정 */
		int startNum = 0;		// 검색 시작 위치
		String text = null;		// 입력한 검색어
        try {
        	startNum = Integer.parseInt(request.getParameter("startNum"));
        	
        	String searchText = request.getParameter("keyword");
        	
			text = URLEncoder.encode(searchText, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
        }
        
        /* API 요청 주소 조합 */
        // display - 한번에 가져올 검색 결과의 수
        // start - 검색 시작 위치
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text
        		+ "&display=10&start=" + startNum;    // JSON 결과
        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // XML 결과

        /* API 설정 */
		Map<String, String> requestHeaders = new HashMap<>();

		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);

		/* API를 호출하여  JSON을 문자열 형태로 반환 */
		String responseBody = NaverSearchAPI.get(apiURL, requestHeaders);
		
		request.setAttribute("responseBody", responseBody);
		request.setAttribute("center", "CarSearchResultView.jsp");
		
		nextPage = "/CarMain.jsp";
	}
}
