package com.sam.aspectj.manyanno;

import org.springframework.stereotype.Repository;

import com.sam.aspectj.jdk.IBaseDao;

@Repository
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

	@Override
	public void saveUser() {
		System.out.println("保存用户saveUser");		
	}
	
}
