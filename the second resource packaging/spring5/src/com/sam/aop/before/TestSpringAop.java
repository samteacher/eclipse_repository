package com.sam.aop.before;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringAop {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aop/before/bean.xml");
		IUserDao userDao = (IUserDao) context.getBean("proxyFactoryBean");
		userDao.saveUser();
	}
}
