package com.sam.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student_class", catalog = "library",uniqueConstraints={@UniqueConstraint(name="index_name",columnNames="name")})
public class Student implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private String code;
	private Timestamp createTime;
	private String context;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name",length=100,nullable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="age",length=100)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name="code_student",length=100)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="createTime",length=100)
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="context",nullable=true)
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Student(String name, Integer age, String code,Timestamp createTime) {
		this.name = name;
		this.age = age;
		this.code = code;
		this.createTime = createTime;
	}

	public Student() {
		super();
	}

}
