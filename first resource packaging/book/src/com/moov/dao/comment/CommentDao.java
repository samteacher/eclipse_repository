package com.moov.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.moov.util.ConnectionUtil;

/**
 * 
 * CommentDao
 * 创建人:Sam
 * 时间：2017年2月23日-下午4:32:47 
 * @version 1.0.0
 *
 */
public class CommentDao {
	
	/**
	 * 根据主健ID查询具体的日记信息
	 * com.moov.dao.comment 
	 * 方法名：getLog
	 * 创建人：Sam
	 * 时间：2017年2月23日-下午4:50:05 
	 * @param id
	 * @return HashMap<String,Object>
	 * @exception 
	 * @since  1.0.0
	 */
	public static HashMap<String, Object> getLog(int id,int userid){
		String sql = "  SELECT * from tm_log WHERE id = "+id+" and userid = "+userid+" ";
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
	
	/**
	 * 用户评论日记保存业务
	 * com.moov.dao.comment 
	 * 方法名：saveCommentLog
	 * 创建人：Sam
	 * 时间：2017年2月24日-下午9:00:42 
	 * @return boolean
	 * @exception 
	 * @since  1.0.0
	 */
	public static boolean saveCommentLog(){
		String sql = "   INSERT INTO tm_comment_log(content,user_id,log_id) VALUES (?,?,?)  ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "xxxx");
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, 1);
			int count = preparedStatement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		saveCommentLog();
	}
	
}
