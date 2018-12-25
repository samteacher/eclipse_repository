package com.sam.aspectj.jdk;

public class UserDao implements IBaseDao{

	@Override
	public void save() {
		System.out.println("保存用户");
	}
	
	public void saveUser() {
		System.out.println("保存用户saveUser");
	}

	@Override
	public void delete() {
		System.out.println("删除用户");
	}

	@Override
	public void update() {
		System.out.println("更新用户");
	}

}
