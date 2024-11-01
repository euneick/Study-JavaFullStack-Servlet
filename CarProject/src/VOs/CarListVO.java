package VOs;

public class CarListVO {

	private int carno;
	private String carname;
	private String carcompany;
	private int carprice;
	private int carusepeople;
	private String carinfo;
	private String carimg;
	private String carcategory;

	public CarListVO() {
	}

	public CarListVO(int carno, String carname, String carcompany, int carprice, int carusepeople, String carinfo,
			String carimg, String carcategory) {

		this.carno = carno;
		this.carname = carname;
		this.carcompany = carcompany;
		this.carprice = carprice;
		this.carusepeople = carusepeople;
		this.carinfo = carinfo;
		this.carimg = carimg;
		this.carcategory = carcategory;
	}

	public int getCarno() {
		return carno;
	}

	public void setCarno(int carno) {
		this.carno = carno;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarcompany() {
		return carcompany;
	}

	public void setCarcompany(String carcompany) {
		this.carcompany = carcompany;
	}

	public int getCarprice() {
		return carprice;
	}

	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}

	public int getCarusepeople() {
		return carusepeople;
	}

	public void setCarusepeople(int carusepeople) {
		this.carusepeople = carusepeople;
	}

	public String getCarinfo() {
		return carinfo;
	}

	public void setCarinfo(String carinfo) {
		this.carinfo = carinfo;
	}

	public String getCarimg() {
		return carimg;
	}

	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}

	public String getCarcategory() {
		return carcategory;
	}

	public void setCarcategory(String carcategory) {
		this.carcategory = carcategory;
	}
}
