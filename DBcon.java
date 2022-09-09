package Store;

import java.sql.*;

public class DBcon {
	
	static Connection con;
	
	public static Connection createc() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//create the Connection
			String user = "root"; //user of mysql
			String password = "harshdoshi"; //password of mysql
			String url = "jdbc:mysql://localhost:3306/newark_shop";
			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
