package com.sam.aop.jdkEncapsulation;

/**
 * Java动态代理测试类
 * 结偶  使用代理解耦 
 * 封装好之后的JDK动态代理
 */
public class Test {

	public static void main(String[] args) {
		
		IUserDao userDao = new SamInvocationUtil<IUserDao>().getObject(UserDaoImpl.class);
		
		userDao.buy("keke");
	
	}
}
