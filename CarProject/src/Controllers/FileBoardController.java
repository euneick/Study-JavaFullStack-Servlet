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

import Services.FileBoardService;

@WebServlet("/FileBoard/*")
public class FileBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileBoardService fileBoardService;
	private PrintWriter printWriter;
	
	private String nextPage;

	public void init(ServletConfig config) throws ServletException {

		fileBoardService = new FileBoardService();
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
		case "/list.bo": openFileBoardListView(request, response); break;

		default:
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
	
	private void openFileBoardListView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
