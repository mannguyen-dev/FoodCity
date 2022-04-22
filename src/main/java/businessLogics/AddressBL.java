package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Address;
import javaBeans.Category;
import javaBeans.User;

public class AddressBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Address createAddress(ResultSet rs) throws SQLException {
		Address a = new Address(rs.getInt("id_address"),
				rs.getString("road"),
				rs.getString("ward"),
				rs.getString("district"),
				rs.getString("city"));
		return a;
	}
	
	public List<Address> getAll(){
		List<Address> list = new ArrayList<>();
		String query = "select * from address";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAddress(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAllCity(){
		List<String> list = new ArrayList<>();
		String query = "select distinct city from address order by city";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAllDistrict(){
		List<String> list = new ArrayList<>();
		String query = "select distinct district from address order by district";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("district"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAllWard(){
		List<String> list = new ArrayList<>();
		String query = "select distinct ward from address order by ward";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("ward"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		AddressBL addBL = new AddressBL();
		//List<Address> list = addBL.getAll();
		//AddressBL.forEach(s->System.out.println(s.toString()));
		List<String> list = addBL.getAllWard();
		list.forEach(s->System.out.println(s));
	}
}
