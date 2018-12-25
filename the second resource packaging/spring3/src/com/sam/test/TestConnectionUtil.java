package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.dao.UserDao;
import com.sam.entity.User;



public class TestConnectionUtil {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserDao uDao = (UserDao) context.getBean("userDao");
		
		User users = (User) uDao.findUsers();
		System.out.println(users);
		
	}
}
