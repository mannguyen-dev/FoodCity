package javaBeans;

public class Role {
	private int idRole;
	private String name;
	private String description;
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role(int idRole, String name, String description) {
		super();
		this.idRole = idRole;
		this.description = description;
		this.name = name;
	}
	public Role() {
		super();
	}
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", name=" + name + ", description=" + description + "]";
	}
}
