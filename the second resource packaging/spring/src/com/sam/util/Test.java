package com.sam.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sam.dao.User;

public class Test {
	
	public static void main(String[] args) throws SQLException {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("E:/myeclipseworkspace/spring/src/applicationContext.xml");
		//System.out.println(context);
		
		User user = (User) context.getBean("userBean");	
		System.out.println(user.getAccount());
		System.out.println(user.getAge());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		BasicDataSource bSource = (BasicDataSource) context.getBean("dataSource");
		//Connection connection = bSource.getConnection();
		
		System.out.println(bSource);
		//System.out.println(connection);
		
		
	}
}
