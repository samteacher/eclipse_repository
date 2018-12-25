package com.sam.util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sam.dao.UserDao;

public class TestUser {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		//ApplicationContext context = new FileSystemXmlApplicationContext("E:/myeclipseworkspace/spring/src/bean.xml");
		
		//WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		UserDao userDao = (UserDao) context.getBean("userDao");

		System.out.println(userDao.getId());
		System.out.println(userDao.getName());
		System.out.println(userDao.getAddress());
	
	}
}
