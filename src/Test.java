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
				System.out.println(rs.getString("userName")+"�û���¼�ɹ�");
				userDao.Colse();
			} else {
				System.out.println("�û������������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
