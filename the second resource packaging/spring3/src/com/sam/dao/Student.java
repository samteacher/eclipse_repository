package com.sam.dao;

public class Student {

	private long id;
	private String name;
	private int age;
	private Teacher teacher;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Student(long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		System.out.println("我的id是"+id+",名字是"+name+",年龄是"+age+"岁！！");
	}
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Student(String name){
		this.name = name;
	}
	
}
