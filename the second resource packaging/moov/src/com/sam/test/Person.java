package com.sam.test;

import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

public class Person {

	private String username;
	private Integer age;
	private String mela;
	private String address;
	private List<User> user;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMela() {
		return mela;
	}

	public void setMela(String mela) {
		this.mela = mela;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Person(String username, Integer age, String mela, String address) {
		super();
		this.username = username;
		this.age = age;
		this.mela = mela;
		this.address = address;
	}

	public Person() {
		super();
	}

}
