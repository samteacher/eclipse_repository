package com.sam.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	private Logger logger = Logger.getLogger(ConnectionUtil.class);

	// 数据库连接
	private Connection connection;
	private String url;
	private String driverName;
	private String username;
	private String password;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void init() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(
					url, username, password);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
