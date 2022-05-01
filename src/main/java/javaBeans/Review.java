package javaBeans;

import java.sql.Date;

public class Review {
	private int idReview;
	private String title;
	private String content;
	private int stars;
	private Date date;
	private int idRestaurant;
	private int idBlog;
	private int idUser;
	public int getIdReview() {
		return idReview;
	}
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public int getIdBlog() {
		return idBlog;
	}
	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Review(int idReview, String title, String content, int stars, Date date, int idRestaurant, int idBlog,
			int idUser) {
		super();
		this.idReview = idReview;
		this.title = title;
		this.content = content;
		this.stars = stars;
		this.date = date;
		this.idRestaurant = idRestaurant;
		this.idBlog = idBlog;
		this.idUser = idUser;
	}
	public Review() {
		super();
	}
	@Override
	public String toString() {
		return "Review [idReview=" + idReview + ", title=" + title + ", content=" + content + ", stars=" + stars
				+ ", date=" + date + ", idRestaurant=" + idRestaurant + ", idBlog=" + idBlog + ", idUser=" + idUser
				+ "]";
	}
}
