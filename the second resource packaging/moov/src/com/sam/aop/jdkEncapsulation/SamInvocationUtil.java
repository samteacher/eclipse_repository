package com.sam.aop.jdkEncapsulation;

import java.lang.reflect.Proxy;

/**
 * 封装动态daili
 * 封装方法
 * @author Administrator
 *
 * @param <T>
 */
public class SamInvocationUtil <T extends Object> {
	
	public T getObject(Class clz){
		try {
			Object object = clz.newInstance();
			UserHandler userHandler = new UserHandler(object);
			T t = (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), userHandler);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
