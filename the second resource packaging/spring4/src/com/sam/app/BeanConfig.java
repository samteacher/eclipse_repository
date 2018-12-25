package com.sam.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sam.dao.UserDao;

@Configuration
public class BeanConfig {

	@Bean
	@Scope("prototype")
	public UserDao userDao(){
		return new UserDao();
	}
}
