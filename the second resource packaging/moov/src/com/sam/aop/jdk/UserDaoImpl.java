package com.sam.aop.jdk;

public class UserDaoImpl implements IUserDao {

	@Override
	public void buy(String name) {
		
		System.out.println(name+"买好洗衣粉了。回家洗衣服！");
		
	}

}
