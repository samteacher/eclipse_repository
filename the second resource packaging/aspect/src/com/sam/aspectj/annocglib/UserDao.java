package com.sam.aspectj.annocglib;

import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	public void save() {
		System.out.println("保存用户");
	}

	public void update() {
		System.out.println("更新用户");
	}

	public void delete() {
		System.out.println("删除用户");
	}
	
}
