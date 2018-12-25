package com.sam.aop.test;

import com.sam.aop.dao.UserDao;
import com.sam.aop.dao.UserDaoImpl;

public class Test01 {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDaoImpl();
		userDao.saveUser(null);
		System.out.println("======");
		userDao.updateUser(1, null);
		System.out.println("======");
		userDao.deleteUser(1);
	}
}
