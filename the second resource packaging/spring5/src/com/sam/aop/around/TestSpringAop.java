package com.sam.aop.around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 环绕通知  MethodInterceptor
 * @author Administrator
 *
 */
public class TestSpringAop {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aop/around/bean.xml");
		IUserDao userDao = (IUserDao) context.getBean("proxyFactoryBean");
		userDao.saveUser();
		userDao.updateUser();
		userDao.deleteUser();
		
	}
}
