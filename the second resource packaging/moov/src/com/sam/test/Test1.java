package com.sam.test;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.Connection;

public class Test1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		User user = (User) context.getBean("keke");
		
		Iterator<String> email = user.getEmail().iterator();
		
		while (email.hasNext()) {
			System.out.println(email.next());
		}
		
		
	}
}
