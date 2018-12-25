package com.sam.service.ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.bean.AdminUser;
import com.sam.bean.User;
import com.sam.dao.IAdminUserMapper;
import com.sam.dao.IUserMapper;
import com.sam.service.IAdminUserService;
import com.sam.service.IUserService;

@Service
public class AdminUserServiceImpl implements IAdminUserService {
	
	@Autowired
	private IAdminUserMapper adminUserMapper;
	
	@Override
	public AdminUser getLogin(AdminUser adminUser) {
		return adminUserMapper.getLogin(adminUser);
	}
	
	
	
}
