package businessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Address;
import javaBeans.Restaurant;
import javaBeans.Review;

public class ReviewBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Review createReview(ResultSet rs) throws SQLException {
		Review r = new Review(rs.getInt("id_review"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getInt("stars"),
				rs.getDate("date"),
				rs.getInt("id_restaurant"),
				rs.getInt("id_blog"),
				rs.getInt("id_user"));
		return r;
	}
	
	public List<Review> getAll(){
		List<Review> list = new ArrayList<>();
		String query = "select * from review";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createReview(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Review> getByIdRestaurant(int idRes, int limit){
		List<Review> list = new ArrayList<>();
		String query = "select * from review where id_restaurant=? order by date desc limit ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idRes);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createReview(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Review> getByIdBlog(int idBlog, int limit){
		List<Review> list = new ArrayList<>();
		String query = "select * from review where id_blog=? order by date desc limit ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idBlog);
			ps.setInt(2, limit);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createReview(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void postCommentRestaurant(String title, String content, int stars, int idRestaurant, int idUser){
		List<Review> list = new ArrayList<>();
		String query = "insert into review (title,content,stars,date,id_restaurant,id_blog,id_user) values (?,?,?,?,?,null,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, stars);
			ps.setDate(4, new Date(System.currentTimeMillis()));
			ps.setInt(5, idRestaurant);
			ps.setInt(6, idUser);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Debug");
		updateReviewRestaurant(stars, idRestaurant);
	}
	
	public void updateReviewRestaurant(int stars, int idRestaurant){
		List<Review> list = new ArrayList<>();
		RestaurantBL resBL = new RestaurantBL();
		Restaurant res = resBL.getById(idRestaurant);
		String query = "update restaurant set stars = ?, review_count = ? where id_restaurant = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, res.getStars()+stars);
			ps.setInt(2, res.getReviewCount()+1);
			ps.setInt(3, idRestaurant);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReviewBL rBL = new ReviewBL();
		List<Review> list = rBL.getByIdRestaurant(1,2);
		list.forEach(s->System.out.println(s));
//		rBL.postCommentRestaurant("Món ăn", "Hợp khẩu vị của mình...", 8, 2, 2);
		//rBL.updateReviewRestaurant(9, 1);
	}
}
