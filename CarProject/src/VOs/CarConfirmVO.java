package VOs;

/**
 * 	non_carorder, carlist 두 테이블을 조인하여 새로운 결과를 담을 VO객체
 */
public class CarConfirmVO {

	private String carname;
	private String carimg;
	private int carprice;
	
	private int orderid;
	private int carreserveday;
	private int carqty;
	private int carins;
	private int carwifi;
	private int carnave;
	private int carbabyseat;
	private String carbegindate;
	
	public CarConfirmVO() {}	

	public CarConfirmVO(String carname, String carimg, int carprice, int orderid, int carreserveday, int carqty,
			int carins, int carwifi, int carnave, int carbabyseat, String carbegindate) {

		this.carname = carname;
		this.carimg = carimg;
		this.carprice = carprice;
		this.orderid = orderid;
		this.carreserveday = carreserveday;
		this.carqty = carqty;
		this.carins = carins;
		this.carwifi = carwifi;
		this.carnave = carnave;
		this.carbabyseat = carbabyseat;
		this.carbegindate = carbegindate;
	}



	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarimg() {
		return carimg;
	}

	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}

	public int getCarprice() {
		return carprice;
	}

	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCarreserveday() {
		return carreserveday;
	}

	public void setCarreserveday(int carreserveday) {
		this.carreserveday = carreserveday;
	}

	public int getCarqty() {
		return carqty;
	}

	public void setCarqty(int carqty) {
		this.carqty = carqty;
	}

	public int getCarins() {
		return carins;
	}

	public void setCarins(int carins) {
		this.carins = carins;
	}

	public int getCarwifi() {
		return carwifi;
	}

	public void setCarwifi(int carwifi) {
		this.carwifi = carwifi;
	}

	public int getCarnave() {
		return carnave;
	}

	public void setCarnave(int carnave) {
		this.carnave = carnave;
	}

	public int getCarbabyseat() {
		return carbabyseat;
	}

	public void setCarbabyseat(int carbabyseat) {
		this.carbabyseat = carbabyseat;
	}

	public String getCarbegindate() {
		return carbegindate;
	}

	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
	}
}
