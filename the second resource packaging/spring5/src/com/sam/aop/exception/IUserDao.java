package com.sam.aop.exception;

import java.sql.SQLException;


public interface IUserDao {

	// 保存用户
	public void saveUser(Integer id) throws SQLException;

	// 删除用户
	public void deleteUser();

	// 更新用户
	public void updateUser();

	
}
