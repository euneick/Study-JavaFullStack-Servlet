package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();		// session 내장 객체 메모리 할당
		session.setAttribute("name", "이순신");			// session 객체에 name 바인딩
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print("<html><body>");
		printWriter.print("<h1>session에 name을 바인딩</h1>");
		printWriter.print("<a href='/pro11/SessionTest/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		printWriter.print("</body></html>");
		
		printWriter.close();
	}

}
