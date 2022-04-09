package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Category;
import javaBeans.Restaurant;
import javaBeans.User;

public class RestaurantBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Restaurant createRestaurant(ResultSet rs) throws SQLException {
		Restaurant restaurant = new Restaurant();
		restaurant.setIdRestaurant(rs.getInt("id_restaurant"));
		restaurant.setName(rs.getString("name"));
		restaurant.setDescription(rs.getString("description"));
		restaurant.setIdAddress(rs.getInt("id_address"));
		restaurant.setStars(rs.getFloat("stars"));
		restaurant.setReviewCount(rs.getInt("review_count"));
		restaurant.setImage(rs.getString("image"));
		restaurant.setOpenTime(rs.getString("open_time"));
		restaurant.setCloseTime(rs.getString("close_time"));
		restaurant.setLinkToBuy(rs.getString("link_to_buy"));
		restaurant.setMinPrice(rs.getDouble("min_price"));
		restaurant.setMaxPrice(rs.getDouble("max_price"));
		restaurant.setIdCategory(rs.getInt("id_category"));
		restaurant.setIdUser(rs.getInt("id_user"));
		return restaurant;
	}
	
	public List<Restaurant> getAllRestaurants(){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getAllRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant limit ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getAllRestaurantsByCategory(int id_cat, int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant where id_category = ? limit ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_cat);
			ps.setInt(2, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getLatestRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant order by id_restaurant desc limit ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getTopRateRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select *, (stars/review_count) as review from restaurant order by review desc, "
				+ "review_count desc limit ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getTopReviewRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant order by review_count desc limit ?";
		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		RestaurantBL bl = new RestaurantBL();
		List<Restaurant> list = bl.getTopReviewRestaurants(6);
		list.forEach(s->System.out.println(s.toString()));
	}
}
