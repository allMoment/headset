package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import utlis.MysqlConnectionFactory;

public class UserDao {
	private MysqlConnectionFactory factory;
	private Connection con;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ResultSet login(String loginName, String password) {
		ResultSet rs = null;
		try {
			factory = new MysqlConnectionFactory();
			con = factory.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from user where loginName=?")
				.append(" and password=?");
			stm = con.prepareStatement(sql.toString());
			stm.setString(1, loginName);
			stm.setString(2, password);
			return stm.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void Colse() {
		factory.Colse(rs, stm, con);
	}

}
