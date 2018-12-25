package com.sam.aspectj.cglib;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class Test {

	public static void main(String[] args) {
		//aspect代理工厂
		AspectJProxyFactory factory = new AspectJProxyFactory();
		ContentDao contentDao = new ContentDao();
		//目标类
		factory.setTarget(contentDao);
		//设值增强类
		factory.addAspect(ContentAspect.class);
		//获取代理类
		ContentDao proxy = factory.getProxy();
		proxy.save();
		proxy.saveUser();
		proxy.update();
		proxy.delete();
	}
}
