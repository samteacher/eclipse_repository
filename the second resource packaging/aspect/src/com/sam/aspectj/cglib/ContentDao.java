package com.sam.aspectj.cglib;


public class ContentDao{

	public void save() {
		System.out.println("保存用户");
	}
	
	protected void saveUser() {
		System.out.println("保存用户saveUser");
	}

	public void delete() {
		System.out.println("删除用户");
	}

	public void update() {
		System.out.println("更新用户");
	}

}
