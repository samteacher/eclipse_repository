package com.sam.aspectj.jdk;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class Test {

	public static void main(String[] args) {
		//aspect代理工厂
		AspectJProxyFactory factory = new AspectJProxyFactory();
		IBaseDao userDao = new UserDao();
		//目标类
		factory.setTarget(userDao);
		//设值增强类
		factory.addAspect(DaoAspect.class);
		//获取代理类
		IBaseDao proxy = factory.getProxy();
		proxy.save();
		proxy.update();
		proxy.delete();
		
	}
}
