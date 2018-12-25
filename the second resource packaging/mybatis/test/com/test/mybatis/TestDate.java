package com.test.mybatis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getDate());
		System.out.println("输出当前时间："+timestamp);
		Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String timeStr = df.format(time);   
		System.out.println(timeStr);//2017-05-06 15:54:21.0   
		
	}
}
