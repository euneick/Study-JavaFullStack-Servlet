package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second7")
public class SecondServlet7 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		// dispatcher로 페이지 요청 시 request가 브라우저를 거치지 않고 바로 전달 됨
		printWriter.print("<html><body>"
				+ "주소 : " + (String) request.getAttribute("address") + "<br>"
				+ "dispatch를 이용한 redirect 바인딩 실습"
				+ "</body></html>");
	}

}
