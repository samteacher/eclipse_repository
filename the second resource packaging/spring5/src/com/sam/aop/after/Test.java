package com.sam.aop.after;

import org.springframework.aop.framework.ProxyFactory;

/**
 * jdk  前置通知，后置通知
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		
		//目标对象
		UserDao userDao = new UserDao();
		//处理
		AfterAdvice logAdvice = new AfterAdvice();
		//代理工厂
		ProxyFactory factory = new ProxyFactory();
		//设置增强类
		factory.setTarget(userDao);
		//为代理目标设置增强类
		factory.addAdvice(logAdvice);
		//设置目标对象接口
		factory.setInterfaces(userDao.getClass().getInterfaces());
		//默认的话jdk动态代理,true就没cglib代理 
		// true的时候      factory.setInterfaces(userDao.getClass().getInterfaces()); 语句写不写都行
		factory.setProxyTargetClass(true);
		
		UserDao userDao2 = (UserDao) factory.getProxy();
		userDao2.saveUser();
	}
}
