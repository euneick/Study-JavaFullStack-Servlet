package VOs;

public class CarOrderVO {

	private int orderId;
	private String id;
	private int carno;
	private int carqty;
	private int carreserveday;
	private String carbegindate;
	private int carins;
	private int carwifi;
	private int carnave;
	private int carbabyseat;
	private String memberphone;
	private String memberpass;

	public CarOrderVO() {
	}

	public CarOrderVO(int orderId, String id, int carno, int carqty, int carreserveday, String carbegindate, int carins,
			int carwifi, int carnave, int carbabyseat, String memberphone, String memberpass) {
	
		this.orderId = orderId;
		this.id = id;
		this.carno = carno;
		this.carqty = carqty;
		this.carreserveday = carreserveday;
		this.carbegindate = carbegindate;
		this.carins = carins;
		this.carwifi = carwifi;
		this.carnave = carnave;
		this.carbabyseat = carbabyseat;
		this.memberphone = memberphone;
		this.memberpass = memberpass;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCarno() {
		return carno;
	}

	public void setCarno(int carno) {
		this.carno = carno;
	}

	public int getCarqty() {
		return carqty;
	}

	public void setCarqty(int carqty) {
		this.carqty = carqty;
	}

	public int getCarreserveday() {
		return carreserveday;
	}

	public void setCarreserveday(int carreserveday) {
		this.carreserveday = carreserveday;
	}

	public String getCarbegindate() {
		return carbegindate;
	}

	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
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

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMemberpass() {
		return memberpass;
	}

	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}	
}
