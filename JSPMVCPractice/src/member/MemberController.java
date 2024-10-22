package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")		/* .../member/ 로 요청된 주소를 모두 받기 */
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private MemberDAO memberDAO;
	
	public void init(ServletConfig config) throws ServletException {

		memberDAO = new MemberDAO();
	}

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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String nextPage = null;
		
		String action = request.getPathInfo(); 		// 마지막 요청 페이지 주소
		
		if (action == null || action.equals("/listMembers.do")) {

			ArrayList<MemberVO> membersList = memberDAO.getMembersList();

			request.setAttribute("membersList", membersList);

			nextPage = "/memberView/listMembers.jsp";
		}
		else if (action.equals("/memberForm.do")) {
			
			nextPage = "/memberView/memberForm.jsp";
		}
		else if (action.equals("/insertMember.do")) {
			
			memberDAO.insertMember(new MemberVO(
					request.getParameter("id"),
					request.getParameter("pwd"),
					request.getParameter("name"),
					request.getParameter("email")));
			
			nextPage = "/member/listMembers.do";
		}
		else {

			ArrayList<MemberVO> membersList = memberDAO.getMembersList();

			request.setAttribute("membersList", membersList);

			nextPage = "/memberView/listMembers.jsp";
		}

		// request에 바인딩 된 값을 공유하기 위해 dispatcher 방식으로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}
}
