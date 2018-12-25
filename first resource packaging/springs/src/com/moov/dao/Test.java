package com.moov.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao dao = (UserDao) context.getBean("userBean");
		System.out.println(dao.getBank());
		System.out.println(dao.getColor());
		System.out.println(dao.getName());
		System.out.println(dao.getSheep());
	}
}
