package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.entity.User;

public class TestUserFactory {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		User user = (User) context.getBean("user");
		User user2 = (User) context.getBean("user2");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user2.getUsername());
		System.out.println(user2.getPassword());
	}
}
