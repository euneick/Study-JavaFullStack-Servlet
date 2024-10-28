package Services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DAOs.MemberDAO;
import VOs.MemberVO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		
		memberDAO = new MemberDAO();
	}
	
	public String getJoinView(HttpServletRequest request) {

		return request.getParameter("center");
	}
	
	public boolean checkJoinId(HttpServletRequest request) {
		
		String id = request.getParameter("inputId");		// ajax 메소드로 호출하면서 등록한 data의 키 값

		return memberDAO.checkJoinId(id);
	}
	
	public void processMemberInsert(HttpServletRequest request) {
		
		String userAddress = request.getParameter("address1") +
				request.getParameter("address2") + 
				request.getParameter("address3") + 
				request.getParameter("address4") + 
				request.getParameter("address5"); 

		MemberVO memberVO = new MemberVO(
				request.getParameter("id"),
				request.getParameter("pass"),
				request.getParameter("name"),
				Integer.parseInt(request.getParameter("age")),
				request.getParameter("gender"),
				userAddress,
				request.getParameter("email"),
				request.getParameter("tel"),
				request.getParameter("hp"));
		
		memberDAO.insertMember(memberVO);
		
	}
	
	public String getLoginView(HttpServletRequest request) {
		
		return "Members/login.jsp";
	}
	
	public boolean processMemberLogin(HttpServletRequest request) {
		
		boolean result = false;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		result = memberDAO.checkMemberLogin(id, pass);
		
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		
		return result;
	}
	
	public void processMemberLogout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();			// 기존에 생성 한 세션 객체 얻기
		//HttpSession session = request.getSession(true);	// 세션 새로 만들기
		
		session.removeAttribute("id");
	}
}
