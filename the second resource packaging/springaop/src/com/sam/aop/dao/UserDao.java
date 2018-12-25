package com.sam.aop.dao;

public interface UserDao {

	// 保存用户
	public void saveUser(User user);

	// 删除用户
	public void deleteUser(Integer id);

	// 更新用户
	public void updateUser(Integer id, User user);


}
