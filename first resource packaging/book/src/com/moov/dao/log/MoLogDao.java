package com.moov.dao.log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.moov.util.ConnectionUtil;

/**
 * 查询日记信息
 * 
 * MoLogDao
 * 创建人:Sam
 * 时间：2017年2月22日-下午10:35:20 
 * @version 1.0.0
 *
 */
public class MoLogDao {
	
	/**
	 * 
	 * 查询用户发表的日记
	 * com.moov.dao.log 
	 * 方法名：findLogs
	 * 创建人：Sam
	 * 时间：2017年2月22日-下午10:42:46  void
	 * @exception 
	 * @since  1.0.0
	 */
	public static List<HashMap<String, Object>> findLogs(int userid){
		String sql = "  SELECT * FROM tm_log where userid = "+userid+" ";
		Connection connection  = null;
		Statement statement = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> maps = null;
		try {
			maps = new ArrayList<HashMap<String,Object>>();
			connection  = ConnectionUtil.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			HashMap<String, Object> map = null;
			while (rs.next()) {
				map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("content", rs.getString("content"));
				map.put("createtime", rs.getTimestamp("createtime"));
				map.put("updatetime", rs.getDate("updatetime"));
				map.put("userid", rs.getInt("userid"));
				maps.add(map);
			}
			return maps;
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
	
	public static void main(String[] args) {
		
		List<HashMap<String, Object>> hashMaps = findLogs(1);
		for (HashMap<String, Object> hashMap : hashMaps) {
			System.out.println(hashMap.get("id"));
			System.out.println(hashMap.get("title"));
			System.out.println(hashMap.get("content"));
			System.out.println(hashMap.get("createtime"));
			System.out.println(hashMap.get("updatetime"));
			System.out.println(hashMap.get("userid"));
		}
		
	}
	
}