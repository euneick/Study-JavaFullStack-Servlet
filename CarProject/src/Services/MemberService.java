package Services;

import DAOs.MemberDAO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		
		memberDAO = new MemberDAO();
	}
}
