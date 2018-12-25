package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.entity.User;

public class TestDouble {
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
		User user1 = (User)context.getBean("user1");
		User user2 = (User)context.getBean("user2");
		User user3 = (User)context.getBean("user3");
		
		System.out.println(user1.getMoney());
		System.out.println(user2.getMoney());
		System.out.println(user3.getMoney());
	}

}
