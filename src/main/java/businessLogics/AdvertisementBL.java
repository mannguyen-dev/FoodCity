package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Advertisement;

public class AdvertisementBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Advertisement createAdvertisement(ResultSet rs) throws SQLException {
		Advertisement a = new Advertisement(rs.getInt("id_ad"),
				rs.getString("image"),
				rs.getInt("id_restaurant"));
		return a;
	}
	
	public List<Advertisement> getAll(){
		List<Advertisement> list = new ArrayList<>();
		String query = "select * from advertisement";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createAdvertisement(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
//		AdvertisementBL aBL = new AdvertisementBL();
//		List<Advertisement> list = aBL.getAll();
//		list.forEach(s->System.out.println(s));
	}
}
