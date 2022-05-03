package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Blog;
import javaBeans.Category;

public class BlogBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Blog createAddress(ResultSet rs) throws SQLException {
		Blog blog = new Blog(rs.getInt("id_blog"),
				rs.getString("title"),
				rs.getString("sub_title"),
				rs.getString("content"),
				rs.getString("cover_img"),
				rs.getInt("id_user"),
				rs.getDate("date"),
				rs.getInt("id_category"),
				rs.getInt("cmt_count"),
				rs.getInt("like_count"));
		return blog;
	}
	
	public List<Blog> getAll(){
		List<Blog> list = new ArrayList<>();
		String query = "SELECT * FROM food_city.blog order by id_blog desc";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Blog> getAll(int limit){
		List<Blog> list = new ArrayList<>();
		String query = "select * from blog order by id_blog desc limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, limit);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Blog> getByCategory(int idCat, int limit){
		List<Blog> list = new ArrayList<>();
		String query = "select * from blog where id_category=? limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idCat);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Blog> getByCategory(int idCat){
		List<Blog> list = new ArrayList<>();
		String query = "select * from blog where id_category=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idCat);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Blog> findByTitle(String title){
		List<Blog> list = new ArrayList<>();
		String query = "select * from blog where title like '%"+title+"%'";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Blog> getOutstanding(int limit){
		List<Blog> list = new ArrayList<>();
		String query = "SELECT * FROM food_city.blog order by cmt_count desc limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, limit);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Blog getById(int idBlog){
		Blog blog = null;
		String query = "select * from blog where id_blog=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idBlog);
			rs = ps.executeQuery();
			if(rs.next()) {
				blog = createAddress(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blog;
	}
	
	public List<Category> getBlogCategory(){
		List<Category> list = new ArrayList<Category>();
		CategoryBL catBL = new CategoryBL();
		String query = "select distinct id_category from blog order by id_category asc";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(catBL.getById(rs.getInt("id_category")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getStringBlogCategory(){
		List<String> list = new ArrayList<>();
		CategoryBL catBL = new CategoryBL();
		String query = "select id_category, count(id_category) as so_luong from blog group by id_category order by id_category asc";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category cat = catBL.getById(rs.getInt("id_category"));
				list.add(cat.getName());
				list.add(rs.getString("so_luong"));
				list.add(String.valueOf(cat.getIdCategory()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
//		BlogBL blogBL = new BlogBL();
//		List<Blog> list = blogBL.findByTitle("top 4");
//		list.forEach(s->System.out.println(s));
//		Blog blog = blogBL.getById(1);
//		System.out.println(blog);
	}
}
