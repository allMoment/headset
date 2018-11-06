package day01;

import java.sql.Connection;
import java.sql.DriverManager;


public class jdbcWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "123456");
			System.out.println("获取到连接:"+connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
