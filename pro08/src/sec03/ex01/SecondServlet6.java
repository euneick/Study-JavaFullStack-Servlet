package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second6")
public class SecondServlet6 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		// 브라우저는 FirstServlet과 SecondServlet을 각각 요청하므로 request는 서로 다른 객체임 
		printWriter.print("<html><body>"
				+ "주소 : " + (String) request.getAttribute("address") + "<br>"
				+ "sendRedirect를 이용한 redirect 바인딩 실습"
				+ "</body></html>");
	}

}
