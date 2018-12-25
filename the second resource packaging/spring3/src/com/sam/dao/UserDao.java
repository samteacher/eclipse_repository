package com.sam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.sam.entity.User;

/**
 * 查询用户信息
 * UserDao<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年1月14日-上午12:05:31 <BR>
 * @version 1.0.0
 *
 */
public class UserDao {
	
	//这个链接工具类的初始化从何而来
	private ConnectionUtil connection;
	
	public UserDao(){
		
	}
	
	public UserDao (ConnectionUtil connection){
		this.connection = connection;
	}
	
	/**
	 * 查询用户信息 
	 * 方法名：findUsers<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年1月14日-上午12:13:18 <BR>
	 * @return List<User><BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public List<User> findUsers(){
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection con = null;
		
		List<User> users = null;
		try{
			con = connection.getConnection();
			users = new ArrayList<User>();
			String sql = "select * from `user`";
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(statement!=null)statement.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public void setConnection(ConnectionUtil connection) {
		this.connection = connection;
	}
}
