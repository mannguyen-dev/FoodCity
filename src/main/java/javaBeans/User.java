package javaBeans;

import java.sql.Date;

public class User {
	private int idUser;
	private String name;
	private String password;
	private Date birthday;
	private boolean gender;
	private String avatar;
	private String email;
	private String phone;
	private int idRole;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public User(int idUser, String name, String password, Date birthday, boolean gender, String avatar, String email,
			String phone, int idRole) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.avatar = avatar;
		this.email = email;
		this.phone = phone;
		this.idRole = idRole;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", gender=" + gender + ", avatar=" + avatar + ", email=" + email + ", phone=" + phone + ", idRole="
				+ idRole + "]";
	}
}
