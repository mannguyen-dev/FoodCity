package javaBeans;

public class Food {
	private int idFood;
	private String name;
	private double price;
	private String image;
	private int idRestaurant;
	public int getIdFood() {
		return idFood;
	}
	public void setIdFood(int idFood) {
		this.idFood = idFood;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public Food(int idFood, String name, double price, String image, int idRestaurant) {
		super();
		this.idFood = idFood;
		this.name = name;
		this.price = price;
		this.image = image;
		this.idRestaurant = idRestaurant;
	}
	public Food() {
		super();
	}
	@Override
	public String toString() {
		return "Food [idFood=" + idFood + ", name=" + name + ", price=" + price + ", image=" + image + ", idRestaurant="
				+ idRestaurant + "]";
	}
}
