package businessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.User;

public class UserBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
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
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				User u = createUser(rs);
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public User getById(int idUser){
		User user = null;
		String query = "select * from user where id_user=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = createUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User loginByEmail(String email, String password){
		String query = "SELECT * FROM `user` WHERE email = ? and password = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				return createUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User loginByPhone(String phone, String password){
		String query = "SELECT * FROM `user` WHERE phone = ? and password = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				return createUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isExistPhone(String phone){
		String query = "SELECT * FROM `user` WHERE phone = ?";
		boolean rt = true;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			rt = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	
	public boolean isExistEmail(String email){
		String query = "SELECT * FROM `user` WHERE email = ?";
		boolean rt = true;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			rt = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	
	public void addUser(User user){
		String query = "insert into user (name, phone, email, avatar, gender, birthday, password, id_role) values (?, ?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAvatar());
			ps.setBoolean(5, user.isGender());
			ps.setDate(6, user.getBirthday());
			ps.setString(7, user.getPassword());
			ps.setInt(8, user.getIdRole());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
//		UserBL bl = new UserBL();
//		List<User> list = bl.getAll();
//		list.forEach(s->System.out.println(s.toString()));
//		User u = bl.loginByEmail("ma","frr");
//		if (u!=null)System.out.println(u.toString());
//		User u2 = bl.loginByEmail("admin1@gmail.com","admin1");
//		if (u2!=null)System.out.println(u2.toString());
//		User u3 = bl.loginByPhone("0792887666","admin1");
//		if (u3!=null)System.out.println(u3.toString());
//		User u = new User();
//		u.setName("text");
//		u.setEmail("text@gmail.com");
//		u.setAvatar("abc.jpg");
//		u.setIdRole(1);
//		u.setGender(false);
//		u.setPassword("123");aaaa
//		u.setBirthday(new Date(1992, 1, 1));
//		u.setPhone("22233445");
//		bl.addUser(u);
		
//		if (bl.isExistEmail("admin1@gmail.com")) System.out.println("Tai khoan ton tai");;
//		if (bl.isExistPhone("079288766")) System.out.println("Tai khoan ton tai");;
		
	}
}
