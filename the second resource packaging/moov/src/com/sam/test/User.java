package com.sam.test;

import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;

public class User {

	private String username;
	private Integer age;
	private Person person;
	private Set<String> email;

	public User() {
		System.out.println("进来了嘛？");
	}

	public User(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<String> getEmail() {
		return email;
	}

	public void setEmail(Set<String> email) {
		this.email = email;
	}

}
