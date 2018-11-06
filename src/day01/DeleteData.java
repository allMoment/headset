package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ids = new int[5];
		for(int i =0; i<5; i++) {
			ids[i] = i;
		}
		int rs = Delete(ids);
		System.out.println("已成功影响行数："+rs);
	}
	
	public static int Delete(int[] ids) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jdbc", "root", "123456");
			Statement statement = con.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from user where id in(");
			for(int i = 0; i < ids.length; i++) {
				sql.append(ids[i]+",");
			}
			String finalsql = sql.substring(0, sql.length()-1)+")";
			System.out.println(finalsql);
			return statement.executeUpdate(finalsql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
