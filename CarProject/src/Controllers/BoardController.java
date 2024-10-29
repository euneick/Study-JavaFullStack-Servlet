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

import Services.BoardService;

@WebServlet("/Board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter printWriter;
	private BoardService boardService;

	private String nextPage;

	public void init(ServletConfig config) throws ServletException {
		
		boardService = new BoardService();
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
			throws ServletException, IOException  {		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		printWriter = response.getWriter();

		String action = request.getPathInfo();
		System.out.println("action : " + action);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
