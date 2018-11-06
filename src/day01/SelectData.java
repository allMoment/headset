package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.User;

public class SelectData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = selectAll();
		System.out.println(users.toString());
		
	}
	public static List<User> selectAll(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jdbc", "root", "123456");
			Statement stm = con.createStatement();
			String sql = "select * from user";
			ResultSet rs = stm.executeQuery(sql);
			List<User> users = new ArrayList<>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
