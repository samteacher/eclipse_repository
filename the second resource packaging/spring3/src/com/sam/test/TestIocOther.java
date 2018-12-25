package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.entity.User;

public class TestIocOther {

	
	public static void main(String[] args) {
		 
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		User user  = (User)context.getBean("user");
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		
		
	}
}
