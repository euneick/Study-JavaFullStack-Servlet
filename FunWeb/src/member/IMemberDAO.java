package member;

public interface IMemberDAO {

	public int validateID(String id);
	public int insertMember(MemberBean memberBean);
	public int checkUser(String id, String pwd);
}
