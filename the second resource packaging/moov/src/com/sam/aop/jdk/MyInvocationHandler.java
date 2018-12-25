package com.sam.aop.jdk;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;

/**
 * 实现InvocationHandler方法
 */
public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("付钱....");
		Object object = method.invoke(target, args);
		System.out.println("登记....");
		return object;
		
	}

}
