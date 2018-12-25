package com.sam.aop.jdkEncapsulation;

public class UserDaoImpl implements IUserDao {

	@Override
	public void buy(String name) {
		
		System.out.println("付钱....");
		System.out.println(name+"买好洗衣粉了。回家洗衣服！");
		System.out.println("登记....");
	}
	
}
