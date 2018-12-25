package com.sam.aspectj.annocglib;

import org.springframework.stereotype.Repository;

@Repository
public class ContentDao  {

	public void save() {
		System.out.println("保存内容");
	}

	public void update() {
		System.out.println("更新内容");
	}

	public void delete() {
		System.out.println("删除内容");
	}
}
