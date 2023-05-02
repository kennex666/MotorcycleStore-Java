package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();
	
	public void connect() throws SQLException {
		String url = "jdbc:sqlsever://localhost:1433;databasename=<>";
		con = DriverManager.getConnection(url,"sa","sapassword");
	}
	
	public static ConnectDB getInstance() {
		return instance;
	}
	
	public void disconnect() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
