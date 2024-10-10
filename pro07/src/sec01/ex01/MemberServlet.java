package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		// DB와 데이터를 주고 받기 위한 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<MemberVO> memberList = memberDAO.getMembersList();
		
		printWriter.print("<html><body>");
		
		printWriter.print("<table border=1>"
				+ "<tr align='center' bgcolor='lightgreen'>"
				+ "<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>"
				+ "</tr>");
		
		for (MemberVO member : memberList) {			
			printWriter.print("<tr>"
					+ "<td>" + member.getId() + "</td>"
					+ "<td>" + member.getPwd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getJoinDate() + "</td>"
					+ "</tr>");
		}
		
		printWriter.print("</body></html>");
	}

}
