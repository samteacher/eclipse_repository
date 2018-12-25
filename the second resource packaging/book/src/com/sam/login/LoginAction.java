package com.sam.login;

public class LoginAction {

	private String username;
	private String password;
	
	public String execute(){
		System.out.println(username+"======="+password);
		return "success";
	}
	
	public String save(){
		System.out.println("资源保存成功！");
		return "success";
	}
	
	public String update(){
		System.out.println("资源更新成功");
		return "success";
	}
	
	public String delete(){
		System.out.println("资源删除成功");
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
