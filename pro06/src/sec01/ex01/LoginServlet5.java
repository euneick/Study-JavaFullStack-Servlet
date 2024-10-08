package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doPost() 메소드 호출");
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	// 응답할 MIME TYPE을 text 형식의 html로 설정
		
		PrintWriter printWriter = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		String data = "<html>"
				+ "<body>"
				+ "아이디 : " + id
				+ "<br>"
				+ "패스워드 : " + pw
				+ "<br>"
				+ "주소 : " + address
				+ "</body>"
				+ "</html>";

		printWriter.print(data);
	}

}
