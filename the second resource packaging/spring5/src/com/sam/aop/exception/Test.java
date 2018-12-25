package com.sam.aop.exception;

import java.sql.SQLException;

import org.springframework.aop.framework.ProxyFactory;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		//目标对象
		UserDao userDao = new UserDao();
		//处理
		ExceptionAdvice exceptionAdvice= new ExceptionAdvice();
		//代理工厂
		ProxyFactory factory = new ProxyFactory();
		//设置增强类
		factory.setTarget(userDao);
		//为代理目标设置增强类
		factory.addAdvice(exceptionAdvice);
		//设置目标对象接口
		factory.setInterfaces(userDao.getClass().getInterfaces());
		//默认的话jdk动态代理,true就没cglib代理 
		// true的时候      factory.setInterfaces(userDao.getClass().getInterfaces()); 语句写不写都行
		factory.setProxyTargetClass(true);
		
		UserDao userDao2 = (UserDao) factory.getProxy();
		userDao2.saveUser(1);
		userDao2.updateUser();
		userDao2.deleteUser();
	}
}
