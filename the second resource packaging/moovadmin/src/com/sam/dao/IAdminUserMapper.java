package com.sam.dao;

import org.springframework.stereotype.Repository;

import com.sam.bean.AdminUser;

@Repository
public interface IAdminUserMapper {

	public AdminUser getLogin(AdminUser adminUser);
}
