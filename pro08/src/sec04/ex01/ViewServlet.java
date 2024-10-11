package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		
		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<MemberVO> memberList = (ArrayList<MemberVO>)request.getAttribute("membersList");
		
		printWriter.print("<html><body>");
		
		printWriter.print("<table border=1>"
				+ "<tr align='center' bgcolor='lightgreen'>"
				+ "<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th><th>삭제</th>"
				+ "</tr>");
		
		for (MemberVO member : memberList) {
			printWriter.print("<tr>"
					+ "<td>" + member.getId() + "</td>"
					+ "<td>" + member.getPwd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getJoinDate() + "</td>"
					+ "<td><a href='/pro08/member?command=deleteMember&id=" + member.getId() + "'>삭제</a></td>"
					+ "</tr>");
		}
		
		printWriter.print("</table>");
		printWriter.print("<a href='memberForm.html'>회원가입</a>");
		printWriter.print("</body></html>");
	}
}
