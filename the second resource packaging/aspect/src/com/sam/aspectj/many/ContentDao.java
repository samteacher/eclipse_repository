package com.sam.aspectj.many;

import com.sam.aspectj.jdk.IBaseDao;

public class ContentDao implements IBaseDao {

	public void save() {
		System.out.println("保存内容");
	}

	public void update() {
		System.out.println("更新内容");
	}

	public void delete() {
		System.out.println("删除内容");
	}

	public void saveUser() {
		System.out.println("保存用户saveUser");
	}
}
