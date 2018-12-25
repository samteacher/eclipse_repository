package com.sam.aop.dao;

/**
 * Java动态代理测试类
 * 结偶  使用代理解耦 
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		
		
		UserDao userDao = new SamInvocationUtil<UserDao>().getObject(UserDaoImpl.class);
		userDao.saveUser(null);
		
		//没有封装之前
//		UserDao userDao = new UserDaoImpl();
//		UserHandler uHandler = new UserHandler(userDao);
//		UserDao uDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), uHandler);
//		System.out.println(uDao.getClass().getName());
//		uDao.saveUser(null);
//		uDao.deleteUser(1);
//		uDao.updateUser(1, new User());
	
	}
}
