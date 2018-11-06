package utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionFactory {
	private static final String URL = "jdbc:mysql://127.0.0.1/jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void Colse(ResultSet rs, Statement stm, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stm != null) stm.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
