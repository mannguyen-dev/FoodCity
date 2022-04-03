package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Category;
import javaBeans.Role;

public class CategoryBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Category> getAllCategory(){
		List<Category> list = new ArrayList<>();
		String query = "select * from category";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Category(rs.getInt("id_category"),
						rs.getString("name"),
						rs.getString("image")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		CategoryBL bl = new CategoryBL();
		List<Category> list = bl.getAllCategory();
		list.forEach(s->System.out.println(s.toString()));
	}
}