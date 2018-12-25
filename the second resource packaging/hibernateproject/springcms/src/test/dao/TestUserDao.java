package test.dao;

import test.TestMain;

import com.tz.dao.UserDao;
import com.tz.entity.User;

public class TestUserDao extends TestMain<UserDao> {

	
	public void test(){
		UserDao userDao = getBean("userDao");
		User user = userDao.getUser("keke", "123456");
		System.out.println(user.getId());
	}
	
	public static void main(String[] args) {
		new TestUserDao().test();
	}
}
