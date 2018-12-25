package com.sam.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserChild implements java.io.Serializable {

	private String address;
	private String male;
	private String job;
	private Integer age;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	public UserChild() {
		super();
	}

	public UserChild(Integer userId) {
		this.userId = userId;
	}
	
	public UserChild(String address, String male, String job, Integer age,
			Integer userId) {
		this.address = address;
		this.male = male;
		this.job = job;
		this.age = age;
		this.userId = userId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
