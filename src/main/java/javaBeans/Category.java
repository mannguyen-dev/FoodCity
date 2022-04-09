package javaBeans;

public class Category {
	private int idCategory;
	private String name;
	private String image;
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Category(int idCategory, String name, String image) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.image = image;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + ", image=" + image + "]";
	}
	
}
