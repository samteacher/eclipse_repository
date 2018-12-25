package com.sam.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	private static final String URL = "jdbc:mysql://localhost:3306/library";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	/**
	 * 
	 * 链接数据库
	 * com.moov.dao 
	 * 方法名：getConnection
	 * 创建人：Sam
	 * 时间：2017年2月21日-下午10:28:08 
	 * @return Connection
	 * @exception 
	 * @since  1.0.0
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(getConnection());
	}
}
