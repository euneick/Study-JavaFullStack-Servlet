package sec04.ex01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

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

		ProcessMemberSelect(request, response);
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
	
	private void ProcessMemberSelect(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		MemberDAO memberDAO = new MemberDAO();
		
		ArrayList<MemberVO> memberList = memberDAO.getMembersList();
		
		request.setAttribute("membersList", memberList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewMembers");
		dispatcher.forward(request, response);
	}
	
	private void ProcessMemberDelete(HttpServletRequest request) {
		
		MemberDAO memberDAO = new MemberDAO();	
		
		if (memberDAO.DeleteMember(request.getParameter("id")))
			System.out.println("회원정보 삭제 완료");
		else
			System.out.println("회원정보 삭제 실패");
	}
}

