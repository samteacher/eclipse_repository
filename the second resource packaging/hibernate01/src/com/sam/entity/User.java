package com.sam.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private String account;
	private UserChild userChild;
	
	public User() {
		super();
	}
	
	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String username, String password, String account,
			UserChild userChild) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.account = account;
		this.userChild = userChild;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@OneToOne(targetEntity=UserChild.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public UserChild getUserChild() {
		return userChild;
	}

	public void setUserChild(UserChild userChild) {
		this.userChild = userChild;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	
}
