/**
 * tzdesk系统平台
 * mybatis
 * com.tz.dao
 * UserDao.java
 * 创建人:xuchengfei 
 * 时间：2015年11月18日-下午10:17:24 
 * 2015潭州教育公司-版权所有
 */
package com.sam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.sam.bean.User;


/**
 * 
 * UserDao
 * 创建人:gege 
 * 时间：2015年11月18日-下午10:17:24 
 * @version 1.0.0
 * 
 */
public class UserDao {

	/**
	 * 查询数据库
	 * @return
	 */
	public List<User> findUsers(){
		Connection connection = null;
		String sql = "  select * from user  ";
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<User> users = null;
		try {
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername("kuku");
				user.setPassword("4654654");
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				if(rs!=null)rs.close();
				if (statement!=null)statement.close();
				if (connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
