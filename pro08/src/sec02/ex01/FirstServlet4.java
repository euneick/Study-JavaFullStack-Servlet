package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first4")
public class FirstServlet4 extends HttpServlet {

	/**
	 * 	Redirect 시 앞선 예제와 달리 URL주소가 변경되지 않음
	 * 	서블릿의 포워드가 서버에서 수행되었기 때문
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("second4");
		dispatcher.forward(request, response);
	}

}
