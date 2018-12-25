package com.sam.service;

import com.sam.bean.User;

public interface IUserService {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User getLogin(User user);
	
}
