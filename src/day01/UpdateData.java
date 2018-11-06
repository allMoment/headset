package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dto.User;

public class UpdateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(9);
		user.setLoginName(" - - - ");
		System.out.println(Update(user));
	}
	
	public static Integer Update(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jdbc", "root", "123456");
			Statement statement = con.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("update user set ");
			if(user.getId() == null) {
				return null;
			}
			int flag = 0;
			if(user.getLoginName() != null) {
				flag++;
				sql.append("loginName = '").append(user.getLoginName()+"',");
			}
			if(user.getPassword() != null) {
				flag++;
				sql.append("passwrod = '").append(user.getPassword()+"',");
			}
			if(user.getUserName() != null) {
				flag++;
				sql.append("userName = '").append(user.getUserName()+"',");
			}
			if(flag == 0) {
				return 0;
			} else {
				String finalSql = sql.substring(0, sql.length()-1);
				finalSql +=" where id="+user.getId();
				System.out.println(finalSql);
				return statement.executeUpdate(finalSql);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
