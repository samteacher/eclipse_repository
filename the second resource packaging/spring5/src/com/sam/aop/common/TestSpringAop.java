package com.sam.aop.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.aop.before.IUserDao;


public class TestSpringAop {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aop/common/bean.xml");
		IUserDao userDao = (IUserDao) context.getBean("proxyFactoryBean");
		userDao.saveUser();
		userDao.updateUser();
		userDao.deleteUser();
	}
}
