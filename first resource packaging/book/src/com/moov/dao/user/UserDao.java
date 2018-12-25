package com.moov.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.moov.util.ConnectionUtil;
/**
 * 用户数据层
 * UserDao
 * 创建人:Sam
 * 时间：2017年2月24日-下午5:13:23 
 * @version 1.0.0
 *
 */
public class UserDao {
	/**
	 * 根据帐号查询用户信息
	 * com.moov.dao.comment 
	 * 方法名：getLog
	 * 创建人：Sam
	 * 时间：2017年2月23日-下午4:50:05 
	 * @param id
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public static HashMap<String, Object> findUser(String username){
		String sql = "  SELECT * from tm_log WHERE account = '"+ username +"'   ";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		HashMap<String, Object> hashMap = null;
		try {
			connection = ConnectionUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			if(rs.next()){
				hashMap = new HashMap<String, Object>();
				hashMap.put("id",rs.getInt("id"));
				hashMap.put("title",rs.getString("title"));
				hashMap.put("content",rs.getString("content"));
				hashMap.put("createtime",rs.getTimestamp("createtime"));
				hashMap.put("updatetime",rs.getDate("updatetime"));
				hashMap.put("userid",rs.getInt("userid"));
			}
			return hashMap;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
}
