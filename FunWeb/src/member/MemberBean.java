package member;

import java.sql.Timestamp;

public class MemberBean {

	private String id;
	private String pwd;
	private String name;
	private Timestamp joinDate;
	private int age;
	private String gender;
	private String email;
	private String address;
	private String tel;
	private String mtel;

	public MemberBean() {}

	public MemberBean(String id, String pwd, String name, int age, String gender, String email, String address,
			String tel, String mtel) {

		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.mtel = mtel;
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

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
}
