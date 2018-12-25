package com.moov.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * SpringMvc中的验证
 * 
 * Content
 * 创建人:Sam
 * 时间：2017年3月18日-下午10:51:08 
 * @version 1.0.0
 *
 */
public class Content {

	//@NotNull(message="标题不允许为空")
	@NotEmpty(message="标题不允许为空")
	private String title;
	//@NotNull(message="描述不允许为空")
	@NotEmpty(message="描述不允许为空")
	private String description;
	@Length(min=0,max=200,message="年龄必须在0-200之前")
	private Integer age;
	@DecimalMin(value="100.00")
	@DecimalMax(value="1000.00")
	private long salary;
	@Past() //必须是一个过去的时间
	@Future //必须是一个将来的时间
	private Date time;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
