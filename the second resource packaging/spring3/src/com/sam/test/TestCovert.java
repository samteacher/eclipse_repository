package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.entity.User;

public class TestCovert {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
		User user = (User)context.getBean("user1");
		System.out.println(user);
		
	}
}
