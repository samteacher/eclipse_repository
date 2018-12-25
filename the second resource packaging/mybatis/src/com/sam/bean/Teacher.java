/**
 * tzdesk系统平台
 * mybatis
 * com.tz.bean
 * Teacher.java
 * 创建人:xuchengfei 
 * 时间：2015年11月20日-下午10:34:55 
 * 2015潭州教育公司-版权所有
 */
package com.sam.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Teacher 创建人:xuchengfei 时间：2015年11月20日-下午10:34:55
 * 
 * @version 1.0.0
 * 
 */
public class Teacher {

	// 老师ID
	private Integer id;
	// 老师名称
	private String username;
	/*对应所有的学生信息*/
	private List<Student> students = new ArrayList<>(0);
	private Integer studentCount;

	public Integer getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}

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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
