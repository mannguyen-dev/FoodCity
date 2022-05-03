package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Address;

public class AddressBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
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
	
	public List<String> getAllCity(){
		List<String> list = new ArrayList<>();
		String query = "select distinct city from address order by city";
		try {
			//conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAllDistrict(){
		List<String> list = new ArrayList<>();
		String query = "select distinct district from address order by district";
		try {
			//conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("district"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> getAllWard(){
		List<String> list = new ArrayList<>();
		String query = "select distinct ward from address order by ward";
		try {
			//conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("ward"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getStringAddress(int idAddress){
		Address add = new Address();
		String query = "select * from address where id_address = ?";
		try {
			//conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idAddress);
			rs = ps.executeQuery();
			if(rs.next()) {
				add = createAddress(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String address = add.getRoad() +(add.getWard().equals("")?"":(", "+add.getWard()))+", " + add.getDistrict()+", " + add.getCity();
		return address;
	}
	
	public Address getAddress(int idAddress){
		Address add = new Address();
		String query = "select * from address where id_address = ?";
		try {
			//conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idAddress);
			rs = ps.executeQuery();
			if(rs.next()) {
				add = createAddress(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return add;
	}
	
	public static void main(String[] args) {
//		AddressBL addBL = new AddressBL();
//		List<Address> list = addBL.getAll();
//		list.forEach(s->System.out.println(s));
	}
}
