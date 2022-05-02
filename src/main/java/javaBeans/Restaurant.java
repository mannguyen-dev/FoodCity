package javaBeans;

public class Restaurant {
	private int idRestaurant;
	private String name;
	private String description;
	private int idAddress;
	private int stars;
	private int reviewCount;
	private String image;
	private String openTime;
	private String closeTime;
	private String linkToBuy;
	private double minPrice;
	private double maxPrice;
	private int idCategory;
	private int idUser;
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getLinkToBuy() {
		return linkToBuy;
	}
	public void setLinkToBuy(String linkToBuy) {
		this.linkToBuy = linkToBuy;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Restaurant(int idRestaurant, String name, String description, int idAddress, int stars,
			int reviewCount, String image, String openTime, String closeTime, String linkToBuy, double minPrice,
			double maxPrice, int idCategory, int idUser) {
		super();
		this.idRestaurant = idRestaurant;
		this.name = name;
		this.description = description;
		this.idAddress = idAddress;
		this.stars = stars;
		this.reviewCount = reviewCount;
		this.image = image;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.linkToBuy = linkToBuy;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.idCategory = idCategory;
		this.idUser = idUser;
	}
	public Restaurant() {
		super();
	}
	@Override
	public String toString() {
		return "Restaurant [idRestaurant=" + idRestaurant + ", name=" + name + ", description=" + description
				+ ", idAddress=" + idAddress + ", stars=" + stars + ", reviewCount=" + reviewCount + ", image=" + image
				+ ", openTime=" + openTime + ", closeTime=" + closeTime + ", linkToBuy=" + linkToBuy + ", minPrice="
				+ minPrice + ", maxPrice=" + maxPrice + ", idCategory=" + idCategory + ", idUser=" + idUser + "]";
	}
}
