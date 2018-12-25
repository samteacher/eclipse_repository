package com.tz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.tz.entity.User;

/**
 * 
 * 查询用户的信息 UserDao<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年1月17日-下午11:52:10 <BR>
 * 
 * @version 1.0.0
 * 
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 根据用户账号和密码查询用户信息
	 * 方法名：getUser<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年1月18日-上午12:44:27 <BR>
	 * @param account
	 * @param password
	 * @return User<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	public User getUser(String account, String password) {
		final User user = new User();
		final String sql = "SELECT id,account,`password`,username FROM tz_user where account = ? AND `password` = ? AND is_delete = 0";
		jdbcTemplate.query(sql, new Object[] { account, password },
				new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						user.setId(rs.getInt("id"));
						user.setAccount(rs.getString("account"));
						user.setPassword(rs.getString("password"));
						user.setUsername(rs.getString("username"));
					}
				});
		return user.getId() == null ? null : user;
	}

}
