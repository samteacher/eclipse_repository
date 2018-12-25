package com.sam.dao;

import com.sam.entity.User;

public class StaticUserFactory {

	
	public static User getUserFactory(){
		
		User user = new User();
		user.setUsername("终结者");
		user.setPassword("7777");
		return user;
		
	}
}
