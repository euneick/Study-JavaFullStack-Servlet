package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet() 메소드 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost() 메소드 호출");
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doHandle() 메소드 호출");
		
		// 요청한 값들 중 한글에 의한 깨짐 방지
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");

		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
	}
}
