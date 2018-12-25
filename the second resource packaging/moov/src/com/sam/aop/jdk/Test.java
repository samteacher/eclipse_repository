package com.sam.aop.jdk;

import net.sf.cglib.proxy.Proxy;


public class Test {
	
	/**
	 * 动态代理测试
	 */
	public static void main(String[] args) {
			
		//目标类
		IUserDao iUserDao = new UserDaoImpl();
		//织入类
		MyInvocationHandler handler = new MyInvocationHandler(iUserDao);
		//代理类
		IUserDao dao = (IUserDao) Proxy.newProxyInstance(iUserDao.getClass().getClassLoader(), iUserDao.getClass().getInterfaces(), handler);
		dao.buy("sam");
		
	}
}
