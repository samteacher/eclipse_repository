package com.sam.service;

import com.sam.bean.AdminUser;

public interface IAdminUserService {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public AdminUser getLogin(AdminUser adminUser);
	
}
