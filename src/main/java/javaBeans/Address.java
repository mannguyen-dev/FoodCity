package javaBeans;

public class Address {
	private int idAddress;
	private String road;
	private String ward;
	private String district;
	private String city;
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(int idAddress, String road, String ward, String district, String city) {
		super();
		this.idAddress = idAddress;
		this.road = road;
		this.ward = ward;
		this.district = district;
		this.city = city;
	}
	public Address() {
		super();
	}
	@Override
	public String toString() {
		return "Address [idAddress=" + idAddress + ", road=" + road + ", ward=" + ward + ", district=" + district
				+ ", city=" + city + "]";
	}
}
