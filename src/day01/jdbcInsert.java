package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.User;

public class jdbcInsert {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		for(int i=0; i<10; i++) {
			User user = new User();
			user.setLoginName("loginName"+i);
			user.setUserName("userName"+i);
			user.setPassword("password"+i);
			users.add(user);
		}
		int rs = Insert(users);
		System.out.println("成功添加行数："+rs);
		
	}
	
	public static int Insert(List<User> users) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "123456");
			Statement statement = connection.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into user(loginName,userName,password) ");
			sql.append(" values");
			for(User user:users) {
				sql.append("('"+user.getLoginName()+"','");
				sql.append(user.getUserName()+"','");
				sql.append(user.getPassword()+"'),");
			}
			String finalsql = sql.toString().substring(0, sql.length()-1);
			System.out.println(finalsql);
			return statement.executeUpdate(finalsql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
