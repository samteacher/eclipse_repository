package com.sam.aop.around;

public class UserDao implements IUserDao{

	public void saveUser() {
		System.out.println("保存用户信息");
	}

	public void deleteUser() {
		System.out.println("修改用户信息");
	}

	public void updateUser() {
		System.out.println("删除用户信息");
	}

}
