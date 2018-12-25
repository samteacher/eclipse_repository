package com.sam.aop.exception;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 环绕通知  MethodInterceptor
 * @author Administrator
 *
 */
public class TestSpringAop {

	
	public static void main(String[] args) throws SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aop/exception/bean.xml");
		IUserDao userDao = (IUserDao) context.getBean("proxyFactoryBean");
		userDao.saveUser(1);
		userDao.updateUser();
		userDao.deleteUser();
		
	}
}
