package businessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private static Connection connection;
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/food_city?useUnicode=true&characterEncoding=UTF-8";
			connection = DriverManager.getConnection(url, "root", "1678");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String[] args) {
		DBContext db = new DBContext();
		Connection com = db.getConnection();
		System.out.println(com.toString());
	}
}
