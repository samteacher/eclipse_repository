package com.moov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class ConnectionUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/book";
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
	
	/**
	 * 
	 * 根据用户和密码查询用户信息
	 * com.moov.dao 
	 * 方法名：findUser
	 * 创建人：Sam
	 * 时间：2017年2月22日-下午2:15:46 
	 * @param account
	 * @param password
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public static HashMap<String, Object> findUser(String account,String password){
		String sql = "  SELECT * FROM tm_user WHERE account = '"+account+"'  AND password = '"+password+"'";
		Connection connection = getConnection();
		Statement statement = null;
		HashMap<String, Object> hashMap = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()){
				hashMap = new HashMap<String, Object>();
				hashMap.put("id", rs.getInt("id"));
				hashMap.put("account", rs.getString("account"));
				hashMap.put("password", rs.getString("password"));
				hashMap.put("nickname", rs.getString("nickname"));
				hashMap.put("createtime", rs.getDate("createtime"));
				hashMap.put("createtime", rs.getTimestamp("createtime"));
				hashMap.put("updatetime", rs.getDate("updatetime"));
				hashMap.put("headerplc", rs.getString("headerplc"));
				hashMap.put("age", rs.getInt("age"));
				hashMap.put("birthday", rs.getDate("birthday"));
				hashMap.put("address", rs.getString("address"));
				hashMap.put("email", rs.getString("email"));
				hashMap.put("male", rs.getInt("male"));
				hashMap.put("telephone", rs.getString("telephone"));
				hashMap.put("description", rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(statement!=null)statement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hashMap;
	}
	
	/**
	 * 
	 * 判断
	 * com.moov.dao 
	 * 方法名：getUserExist
	 * 创建人：Sam
	 * 时间：2017年2月22日-下午3:30:48 
	 * @param account
	 * @param password
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean getUserExist(String account,String password){
		String sql = "  SELECT COUNT(1) FROM tm_user WHERE account = '"+account+"' AND `password` = '"+password+"'  ";
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			System.out.println(sql);
			int count = 0;
			//如何能确保结果集只返回一条的话，就使用if
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count > 0 ? true : false;
//			while(){  返回的结果集是多条的  一般都使用我们的集合list作为返回值的类型
//			}
		} catch (SQLException e) {
			return false;
		}finally{
			try {
				if(rs!=null)rs.close();
				if(statement!=null)statement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
}