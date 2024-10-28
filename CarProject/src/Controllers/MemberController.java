package Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.MemberService;

@WebServlet("/Member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PrintWriter printWriter;
	private MemberService memberService;
	
	private String nextPage;

	public void init(ServletConfig config) throws ServletException {

		memberService = new MemberService();
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
		
		switch (action) {
		case "/join.me": openJoinView(request, response); break;
		case "/joinIdCheck.me": checkJoinId(request, response); return;
		case "/joinPro.me": processMemberInsert(request, response); break;
		case "/login.me": openLoginView(request, response); break;
		case "/loginPro.me": if (!processMemberLogin(request, response)) return; break;

		default:
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	private void openJoinView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String center = null;
		
		center = memberService.getJoinView(request);
		request.setAttribute("center", center);
		
		nextPage = "/CarMain.jsp";
	}
	
	private void checkJoinId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = memberService.checkJoinId(request);
		
		printWriter.print(result ? "not usable" : "usable");
	}
	
	private void processMemberInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		memberService.processMemberInsert(request);

		nextPage = "/CarMain.jsp";
	}
	
	private void openLoginView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String center = memberService.getLoginView(request);

		request.setAttribute("center", center);
		
		nextPage = "/CarMain.jsp";
	}
	
	private boolean processMemberLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = memberService.processMemberLogin(request);
		
		if (result) {
			nextPage = "/CarMain.jsp";
		}
		else {
			printWriter.print("<script>");
			printWriter.print("window.alert('아이디 또는 비밀번호가 잘못되었습니다.');");
			printWriter.print("history.go(-1);");
			printWriter.print("</script>");
		}
		
		return result;
	}
}
