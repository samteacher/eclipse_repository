package com.moov.dao;

import java.lang.reflect.*;

public class UserReflect {
	
	public static void main(String[] args) {
		
		try {
			//获取userdao的模板，获取这个类的字节文件
			Class clz = Class.forName("com.moov.bean.UserDao");
			//方法解析
			UserDao userDao = (UserDao) clz.newInstance();
			
			Field bankField = clz.getDeclaredField("bank");
			//可以获取私有属性
			bankField.setAccessible(true);
			bankField.set(userDao, "中国银行");
			
			Field colorField = clz.getDeclaredField("color");
			colorField.setAccessible(true);
			colorField.set(userDao,"黑色");
			
			Field nameField = clz.getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(userDao,"奥迪");
			
			Field sheepField = clz.getDeclaredField("sheep");
			colorField.set(userDao,"560");
			
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}
