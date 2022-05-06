package businessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Role;

public class RoleBL {
	DBContext db = new DBContext();
	Connection conn = db.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Role> getAllRole(){
		List<Role> list = new ArrayList<>();
		String query = "select * from role";
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Role(rs.getInt("id_role"),
						rs.getString("name"),
						rs.getString("description")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Role getByIdRole(int idRole){
		Role role = null;
		String query = "select * from role where id_role=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, idRole);
			rs = ps.executeQuery();
			if(rs.next()) {
				role = new Role(rs.getInt("id_role"),
						rs.getString("name"),
						rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public static void main(String[] args) {
//		RoleBL r = new RoleBL();
//		List<Role> list = r.getAllRole();
//		list.forEach(s->System.out.println(s.toString()));
	}
}
