package com.sam.bean;

public class User {

	private Integer id;
	private String username;
	private String age;
	private String password;
	private String account;
	private String address;
	private String male;
	private String job;

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public User() {
		super();
	}

	public User(Integer id, String username, String age, String password,
			String account, String address, String male, String job) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.password = password;
		this.account = account;
		this.address = address;
		this.male = male;
		this.job = job;
	}
	

}
