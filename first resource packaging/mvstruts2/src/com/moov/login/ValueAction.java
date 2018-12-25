package com.moov.login;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

public class ValueAction implements ServletRequestAware {

	private HttpServletRequest request;
	private String username;
	private String password;

	public String save() throws UnsupportedEncodingException {
		System.out.println(request.getParameter("username"));
		username = new String(username.getBytes("ISO8859-1"),"UTF-8");
		password = request.getParameter("password");
		System.out.println(username+"==="+password);
		return "save";
	}

	public String list() {
		request.setAttribute("content", "小鱼鱼");
		request.getSession().setAttribute("content", "我吐头刨个坑");
		request.getServletContext().setAttribute("content", "的看法就是敌法师");
		return "list";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
