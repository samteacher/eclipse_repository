package com.moov.login;

/**
 * 登录处理的方法
 * LoginAction
 * 创建人:Sam
 * 时间：2017年2月27日-下午2:45:59 
 * @version 1.0.0
 *
 */

/* public class LoginAction extends ActionSupport 
 * 最新版本的struts2不需要继承的 
 */
public class LoginAction {
	
	private String username;
	private String password;
	
	//类的入口方法 execute() 一个Action类的默认方法
	public String execute(){
		return "success";
	}
	
	public String save(){
		return "success";
	}
	
	public String delete(){
		System.out.println("删除文件进去这里了");
		return "success";
	}
	
	public String update(){
		System.out.println("更新文件进去这里了");
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
