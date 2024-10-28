package Services;

import javax.servlet.http.HttpServletRequest;

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
}
