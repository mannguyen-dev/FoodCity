package javaBeans;

public class Advertisement {
	private int idAdvertisement;
	private String image;
	private int idRestaurant;
	public int getIdAdvertisement() {
		return idAdvertisement;
	}
	public void setIdAdvertisement(int idAdvertisement) {
		this.idAdvertisement = idAdvertisement;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public Advertisement(int idAdvertisement, String image, int idRestaurant) {
		super();
		this.idAdvertisement = idAdvertisement;
		this.image = image;
		this.idRestaurant = idRestaurant;
	}
	public Advertisement() {
		super();
	}
	@Override
	public String toString() {
		return "Advertisement [idAdvertisement=" + idAdvertisement + ", image=" + image + ", idRestaurant="
				+ idRestaurant + "]";
	}
	
	
}
