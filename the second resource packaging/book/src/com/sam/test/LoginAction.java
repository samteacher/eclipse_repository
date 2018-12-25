package com.sam.test;

public class LoginAction {

	private String username;
	
	public String login(){
		System.out.println("登陆用户");
		return "login";
	}
	
	public String register(){
		System.out.println("注册用户");
		return "login";
	}
	
	public String logout(){
		System.out.println("注销用户");
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
