package com.sam.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.dao.Teacher;
import com.sam.entity.User;

public class TestTeacher {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//		Teacher teacher =(Teacher) context.getBean("teacher");
//		System.out.println(teacher.getId());
//		System.out.println(teacher.getName());
//		System.out.println(teacher.getAge());
		
		
		Teacher teacher = (Teacher) context.getBean("teacher");
		System.out.println(teacher.getName());
		System.out.println(teacher.getStudent().getName());
		
		
	}
}
