package com.sam.aspectj.many;

import com.sam.aspectj.jdk.IBaseDao;

public class UserDao implements IBaseDao {

	public void save() {
		System.out.println("保存用户");
	}

	public void update() {
		System.out.println("更新用户");
	}

	public void delete() {
		System.out.println("删除用户");
	}

	public void saveUser() {
		System.out.println("保存用户saveUser");
	}
	
}
