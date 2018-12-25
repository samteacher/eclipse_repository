package com.sam.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sam.dao.Student;

public class TestStudent {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		Student stut =(Student) context.getBean("student");
		
//		Resource resource = new ClassPathResource("bean.xml");
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		Student stu = (Student) beanFactory.getBean("student");
//			
//		System.out.println(stu.getId()+"==="+stu.getName()+"====="+stu.getAge());
	
	}
		
}
