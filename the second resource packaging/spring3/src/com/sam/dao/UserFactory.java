package com.sam.dao;

import com.sam.entity.User;

public class UserFactory {

	
	public User getUserFactory(){
		
		User user = new User();
		user.setUsername("织梦者");
		user.setPassword("8888888");
		return user;
		
	}
}
