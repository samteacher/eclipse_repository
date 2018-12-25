package com.sam.aspectj.many;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sam.aspectj.jdk.IBaseDao;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sam/aspectj/many/bean.xml");
		IBaseDao userDao = (IBaseDao) context.getBean("userDao");
		userDao.save();
		userDao.update();
		userDao.delete();
		
		System.out.println("==============课程=====================");
		IBaseDao contentDao = (IBaseDao) context.getBean("contentDao");
		contentDao.save();
		contentDao.update();
		contentDao.delete();
		
	}
}
