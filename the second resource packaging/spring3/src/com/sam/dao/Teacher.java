package com.sam.dao;


public class Teacher {

	private Integer id;
	private String name;
	private Integer age;
	private Student student;
	
	
	public Teacher() {
		System.out.println("我的id是" + id + ",名字是" + name + ",年龄是" + age + "岁！！");
	}

	public Teacher(Integer id, String name, Integer age) {
		System.out.println("进入了1111......");
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Teacher(String name, Integer id,  Integer age) {
		System.out.println("进入了2222......");
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	//交叉注入
	public Teacher(String name){
		this.name = name;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

}
