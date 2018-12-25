package com.sam.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static Connection getConn() {
	    Connection conn = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver"); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "123456");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	
	public static void main(String[] args) {
		
		System.out.println(getConn());
	}
}
