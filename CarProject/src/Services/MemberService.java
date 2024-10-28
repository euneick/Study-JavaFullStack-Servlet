package Services;

import javax.servlet.http.HttpServletRequest;

import DAOs.MemberDAO;

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
		
	}
}
