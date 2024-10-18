package sec01.ex01;

public class MemberBean {

	private String id;
	private String pwd;
	private String name;
	private int age;
	private String address;
	
	public MemberBean() {}

	public MemberBean(String id, String pwd, String name, int age, String address) {
	
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
