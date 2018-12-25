package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.app.BeanConfig;

public class TestBean {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		BeanConfig beanConfig = (BeanConfig)context.getBean("beanConfig");
		System.out.print(beanConfig);
	}
}
