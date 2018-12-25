package com.sam.test;

import com.sam.annotation.LogAnnotation;
import com.sam.annotation.Parameter;

@SmLogAnnocation(username="dkfjalskdfj",value="类注解")
public class TestService {

	@SmLogAnnocation(username="这里是一个属性",value="username")
	private String username;
	
	@SmLogAnnocation("UserService")
	public TestService(){
		
	}
	
	@SmLogAnnocation("我是一个方法注解哟")
	public void saveUser(@Parameter String name) {
		System.out.println("保存用户");
	}
	
	
}
