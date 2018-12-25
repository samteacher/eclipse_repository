package com.sam.entity;

import javax.xml.crypto.Data;

import com.sam.dao.Teacher;

/**
 * 用户表 User<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年1月13日-下午11:51:28 <BR>
 * 
 * @version 1.0.0
 * 
 */
public class User {

	/* 主键 */
	private Integer id;
	/* 用户名 */
	private String username;
	/* 密码 */
	private String password;

	private Data data;

	private Double money;

	public User() {

	}

	public User(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return data;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
