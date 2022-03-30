package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Role;

public class RoleBL {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Role> getAllRole(){
		List<Role> list = new ArrayList<>();
		String query = "select * from role";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Role(rs.getInt("id_role"),
						rs.getString("name"),
						rs.getString("description")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		RoleBL r = new RoleBL();
		List<Role> list = r.getAllRole();
		list.forEach(s->System.out.println(s.toString()));
	}
}
