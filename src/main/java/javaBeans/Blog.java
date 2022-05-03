package javaBeans;

import java.sql.Date;

public class Blog {
	private int idBlog;
	private String title;
	private String subTitle;
	private String content;
	private String coverImg;
	private int idUser;
	private Date date;
	private int idCategory;
	private int cmtCount;
	private int likeCount;
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public int getIdBlog() {
		return idBlog;
	}
	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCoverImg() {
		return coverImg;
	}
	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public Blog() {
		super();
	}
	@Override
	public String toString() {
		return "Blog [idBlog=" + idBlog + ", title=" + title + ", subTitle=" + subTitle + ", content=" + content
				+ ", coverImg=" + coverImg + ", idUser=" + idUser + ", date=" + date + ", idCategory=" + idCategory
				+ ", cmtCount=" + cmtCount + ", likeCount=" + likeCount + "]";
	}
	public Blog(int idBlog, String title, String subTitle, String content, String coverImg, int idUser, Date date,
			int idCategory, int cmtCount, int likeCount) {
		super();
		this.idBlog = idBlog;
		this.title = title;
		this.subTitle = subTitle;
		this.content = content;
		this.coverImg = coverImg;
		this.idUser = idUser;
		this.date = date;
		this.idCategory = idCategory;
		this.cmtCount = cmtCount;
		this.likeCount = likeCount;
	}
}
