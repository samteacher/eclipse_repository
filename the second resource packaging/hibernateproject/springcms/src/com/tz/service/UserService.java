package com.tz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tz.dao.UserDao;
import com.tz.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
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
	public User getUser(String account,String password){
		return userDao.getUser(account, password);
	}
}
