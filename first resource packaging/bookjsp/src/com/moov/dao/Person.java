package com.moov.dao;

public class Person {

	private String username;
	private String address;
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String username, String address, Integer age) {
		super();
		this.username = username;
		this.address = address;
		this.age = age;
	}

}
