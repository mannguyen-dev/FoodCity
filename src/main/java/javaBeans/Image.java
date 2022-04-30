package javaBeans;

public class Image {
	private int idImage;
	private String name;
	private String description;
	private int idAlbum;
	private int idRestaurant;
	private int idReview;
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
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
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public int getIdReview() {
		return idReview;
	}
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", name=" + name + ", description=" + description + ", idAlbum=" + idAlbum
				+ ", idRestaurant=" + idRestaurant + ", idReview=" + idReview + "]";
	}
	public Image(int idImage, String name, String description, int idAlbum, int idRestaurant, int idReview) {
		super();
		this.idImage = idImage;
		this.name = name;
		this.description = description;
		this.idAlbum = idAlbum;
		this.idRestaurant = idRestaurant;
		this.idReview = idReview;
	}
	public Image() {
		super();
	}
	
}
