package Services;

import javax.servlet.http.HttpServletRequest;

import DAOs.MemberDAO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		
		memberDAO = new MemberDAO();
	}
	
	public String getJoinView(HttpServletRequest request) {

		System.out.println(request.getParameter("center"));
		return request.getParameter("center");
	}
}
