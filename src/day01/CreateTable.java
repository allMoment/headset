package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
			String user = "root";
			String password = "123456";
			Connection con = DriverManager.getConnection(url,user,password);
			Statement statement = con.createStatement();
			StringBuilder sql = new StringBuilder();
//			sql.append("create table user(");
//			sql.append(" id int primary key auto_increment ,");
//			sql.append(" loginName varchar(20) ,");
//			sql.append(" userName varchar(20) ,");
//			sql.append(" password varchar(20) ");
//			sql.append(")");
//			int result = statement.executeUpdate(sql.toString());
//			System.out.println("已影响："+result);
			sql.append("insert into user(loginName,userName,password) values('123','123','123')");
			int rs = statement.executeUpdate(sql.toString());
			System.out.println("成功添加行数："+rs);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
