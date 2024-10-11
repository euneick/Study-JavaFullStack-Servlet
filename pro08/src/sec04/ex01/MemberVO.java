package sec04.ex01;

import java.sql.Date;

/**
 * 	VO (Value Object) 역할 클래스
 * 		- DB의 데이블에서 조회한 값들을 한번에 받아와서 저장하는 객체
 */
public class MemberVO {

	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;		// java.util 라이브러리가 아닌 java.sql 라이브러리로 선택해야 함

	public MemberVO() {
		System.out.println("MemberVO 생성자 호출");
	}
	
	public MemberVO(String id, String pwd, String name, String email) {
	
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
