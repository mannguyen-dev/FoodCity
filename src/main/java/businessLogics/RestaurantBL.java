package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Restaurant;

public class RestaurantBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Restaurant createRestaurant(ResultSet rs) throws SQLException {
		Restaurant restaurant = new Restaurant();
		restaurant.setIdRestaurant(rs.getInt("id_restaurant"));
		restaurant.setName(rs.getString("name"));
		restaurant.setDescription(rs.getString("description"));
		restaurant.setIdAddress(rs.getInt("id_address"));
		restaurant.setStars(rs.getInt("stars"));
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
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Restaurant getById(int idRes){
		Restaurant res = null;
		String query = "select * from restaurant where id_restaurant=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idRes);
			rs = ps.executeQuery();
			while(rs.next()) {
				res = createRestaurant(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Restaurant> getAllRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getAllRestaurantsByCategory(int id_cat, int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant where id_category = ? limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_cat);
			ps.setInt(2, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getLatestRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant order by id_restaurant desc limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getTopRateRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select *, (stars/review_count) as review from restaurant order by review desc, "
				+ "review_count desc limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> getTopReviewRestaurants(int number){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant order by review_count desc limit ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Restaurant> find(String name, String idCat, String ward, String district, String city){
		List<Restaurant> list = new ArrayList<>();
		String query = "select * from restaurant inner join address on restaurant.id_address = address.id_address where ";
		if ( name != null && !name.equals("")) query += (query.endsWith("where ")?"":" and ") + "name like '%"+name+"%' ";
		if (idCat != null && !idCat.equals("")) query += (query.endsWith("where ")?"":" and ") + "id_category = "+idCat;
		if (ward != null && !ward.equals("")) query += (query.endsWith("where ")?"":" and ") + "ward = '"+ward+"' ";
		if (district != null && !district.equals("")) query += (query.endsWith("where ")?"":" and ") + "district = '"+district+"' ";
		if (city != null && !city.equals("")) query += (query.endsWith("where ")?"":" and ") + "city = '"+city+"' ";
		System.out.println(query);
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createRestaurant(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
//		RestaurantBL bl = new RestaurantBL();
//		List<Restaurant> list = bl.find(null,"","","Quận 1","TP.HCM");
//		list.forEach(s->System.out.println(s.toString()));
	}
}
