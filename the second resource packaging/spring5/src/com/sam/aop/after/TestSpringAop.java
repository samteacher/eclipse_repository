package com.sam.aop.after;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringAop {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aop/after/bean.xml");
		IUserDao userDao = (IUserDao) context.getBean("proxyFactoryBean");
		userDao.saveUser();
	}
}
