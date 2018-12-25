package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person.getUsername()+"==="+person.getAddress()+"==="+person.getUser());
		
		for (User user : person.getUser()) {
			System.out.println(user.getUsername()+"---"+user.getAge());
		}
		
	}
}
