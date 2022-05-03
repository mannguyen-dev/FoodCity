package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Image;

public class ImageBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private Image createImage(ResultSet rs) throws SQLException {
		Image a = new Image(rs.getInt("id_image"),
				rs.getString("name"),
				rs.getString("description"),
				rs.getInt("id_album"),
				rs.getInt("id_restaurant"),
				rs.getInt("id_review"));
		return a;
	}
	
	public List<Image> getAll(){
		List<Image> list = new ArrayList<>();
		String query = "select * from image";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createImage(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Image> getByIdResAlbum(int idRes, int idAlbum){
		List<Image> list = new ArrayList<>();
		String query = "select * from image where id_restaurant =? and id_album=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idRes);
			ps.setInt(2, idAlbum);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(createImage(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
//		ImageBL iBL = new ImageBL();
//		List<Image> list = iBL.getByIdResAlbum(3,2);
//		list.forEach(s->System.out.println(s));
	}
}
