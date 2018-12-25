package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ReflectDemo {

	public static void main(String[] args) {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		User user = (User) context.getBean("user");
		//User user = (User) context.getBean(User.class);
		//User user = (User) context.getBean("userConstructor");
		System.out.println(user.getUsername()+"========="+user.getAge()+"==="+user.getPerson().getUsername());
		
		Person person = user.getPerson();
		System.out.println(person.getUsername()+"==="+person.getAddress());
		
		
	}
	
}
