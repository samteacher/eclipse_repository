/**
 * tzdesk系统平台
 * mybatis
 * com.tz.bean
 * Student.java
 * 创建人:xuchengfei 
 * 时间：2015年11月20日-下午10:35:43 
 * 2015潭州教育公司-版权所有
 */
package com.sam.bean;

/**
 * 
 * Student 创建人:xuchengfei 时间：2015年11月20日-下午10:35:43
 * 
 * @version 1.0.0
 * 
 */
public class Student {

	// 主键
	private Integer id;
	// 学生名册
	private String uname;
	// 教室名称
	private String classname;
	// 老师id
	private Integer teacher_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

}
