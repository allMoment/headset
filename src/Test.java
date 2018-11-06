import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import utlis.MysqlConnectionFactory;

public class Test {

	public static void main(String[] args) {
		try {
			UserDao userDao = new UserDao();
			String loginName = "loginName3";
			String password = "password3";
			ResultSet rs = userDao.login(loginName, password);
			if(rs.next()) {
				System.out.println(rs.getString("userName")+"用户登录成功");
				userDao.Colse();
			} else {
				System.out.println("用户名或密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
