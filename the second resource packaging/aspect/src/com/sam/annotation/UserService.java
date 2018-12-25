package com.sam.annotation;

/**
 * 注解类
 * @author Administrator
 *
 */
@LogAnnotation(username="sam",value="2f234234")
public class UserService {

	@LogAnnotation(username="这里是一个属性",value="username")
	private String username;
	
	@LogAnnotation("UserService")
	public UserService(){
		
	}
	
	@LogAnnotation("我是一个方法注解哟")
	public void saveUser(@Parameter String name,@Parameter("23") int age) {
		System.out.println("保存用户");
	}
	
}
