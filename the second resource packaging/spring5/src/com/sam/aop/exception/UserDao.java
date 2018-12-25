package com.sam.aop.exception;

import java.sql.SQLException;

public class UserDao implements IUserDao{

	public void saveUser(Integer id) throws SQLException {
		try {
			System.out.println("保存用户信息"+id);
			System.out.println(1/0);
		} catch (Exception e) {
			throw new SQLException("数据更新出现了异常");
		}
	}

	public void deleteUser() {
		System.out.println("修改用户信息");
	}

	public void updateUser() {
		System.out.println("删除用户信息");
	}

}
