package com.sam.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.sam.test.User;

@Component
public class Beans {

	@Bean(name="user")
	public User getUser(){
		User user = new User();
		user.setUsername("samteacher");
		user.setAge(23);
		return user;
	}
	
	
}
