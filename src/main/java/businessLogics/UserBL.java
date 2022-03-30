package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.User;

public class UserBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private User createUser(ResultSet rs) throws SQLException {
		User u = new User();
		u.setIdUser(rs.getInt("id_user"));
		u.setIdRole(rs.getInt("id_role"));
		u.setName(rs.getString("name"));
		u.setPassword(rs.getString("password"));
		u.setPhone(rs.getString("phone"));
		u.setEmail(rs.getString("email"));
		u.setGender(rs.getBoolean("gender"));
		u.setBirthday(rs.getDate("birthday"));
		u.setAvatar(rs.getString("avatar"));
		return u;
	}
	
	public List<User> getAll(){
		List<User> list = new ArrayList<>();
		String query = "select * from user";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = createUser(rs);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public User loginByEmail(String email, String password){
		String query = "SELECT * FROM `user` WHERE email = ? and password = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				return createUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User loginByPhone(String phone, String password){
		String query = "SELECT * FROM `user` WHERE phone = ? and password = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				return createUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		UserBL bl = new UserBL();
//		List<User> list = bl.getAll();
//		list.forEach(s->System.out.println(s.toString()));
		User u = bl.loginByEmail("ma","frr");
		if (u!=null)System.out.println(u.toString());
		User u2 = bl.loginByEmail("admin1@gmail.com","admin1");
		if (u2!=null)System.out.println(u2.toString());
		User u3 = bl.loginByPhone("0792887666","admin1");
		if (u3!=null)System.out.println(u3.toString());
		
	}
}
