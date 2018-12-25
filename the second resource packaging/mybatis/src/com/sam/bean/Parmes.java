package com.sam.bean;

import java.util.List;

/**
 * 模糊查詢Parmes
 * 
 * 模糊查詢的查村方法
 * 
 * @author Administrator
 * 
 */
public class Parmes {

	private String username;
	private String password;
	private String order;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private Integer id;
	private Integer teacher_id;
	private String ids;
	private List<Integer> optis;
	
	public List<Integer> getOptis() {
		return optis;
	}

	public void setOptis(List<Integer> optis) {
		this.optis = optis;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
