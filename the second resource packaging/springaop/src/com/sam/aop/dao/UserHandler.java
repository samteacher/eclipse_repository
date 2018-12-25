package com.sam.aop.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * java动态代理类
 * @author Administrator
 *
 */
public class UserHandler implements InvocationHandler {

	private Object target;
	
	public UserHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object object = method.invoke(target, args);
		return null;
	}

}
