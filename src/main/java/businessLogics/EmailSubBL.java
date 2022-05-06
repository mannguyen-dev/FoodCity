package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.EmailSub;

public class EmailSubBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private EmailSub createAddress(ResultSet rs) throws SQLException {
		EmailSub a = new EmailSub(rs.getInt("id_emailSub"),
				rs.getString("email"));
		return a;
	}
	
	public List<EmailSub> getAll(){
		List<EmailSub> list = new ArrayList<>();
		String query = "select * from Email_Sub";
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
	
	public void insertEmail(String email){
		List<EmailSub> list = getAll();
		for (EmailSub es: list) {
			if (es.getEmail().equals(email)) return;
		}
		String query = "insert into email_sub (email) values (?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		EmailSubBL addBL = new EmailSubBL();
//		addBL.insertEmail("test4@gmail.com");
//		List<EmailSub> list = addBL.getAll();
//		list.forEach(s->System.out.println(s.toString()));
	}
}
