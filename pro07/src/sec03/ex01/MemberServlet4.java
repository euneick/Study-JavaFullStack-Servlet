package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet4 extends HttpServlet {

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

		String command = request.getParameter("command");
		
		if (command != null && command.equals("registMember"))
			ProcessMemberInsert(request);
		else if (command != null && command.equals("deleteMember"))
			ProcessMemberDelete(request);

		ProcessMemberSelect(response);
	}
	
	private void ProcessMemberInsert(HttpServletRequest request) throws ServletException, IOException {

		MemberDAO memberDAO = new MemberDAO();

		MemberVO memberVO = new MemberVO(request.getParameter("id"),
				request.getParameter("pwd"),
				request.getParameter("name"),
				request.getParameter("email"));

		if (memberDAO.RegistMember(memberVO)) {
			System.out.println("회원가입 성공");
		}
		else {
			System.out.println("회원가입 실패");
		}
	}
	
	private void ProcessMemberSelect(HttpServletResponse response) throws IOException {

		PrintWriter printWriter = response.getWriter();
		
		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<MemberVO> memberList = memberDAO.getMembersList();
		
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
					+ "<td><a href='/pro07/member4?command=deleteMember&id=" + member.getId() + "'>삭제</a></td>"
					+ "</tr>");
		}
		
		printWriter.print("</table></body></html>");
	}
	
	private void ProcessMemberDelete(HttpServletRequest request) {
		
		MemberDAO memberDAO = new MemberDAO();	
		
		if (memberDAO.DeleteMember(request.getParameter("id")))
			System.out.println("회원정보 삭제 완료");
		else
			System.out.println("회원정보 삭제 실패");
	}
}

