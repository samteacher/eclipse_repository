package com.tz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 用户类 User<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年1月18日-上午12:29:03 <BR>
 * 
 * @version 1.0.0
 * 
 */
@Entity
@Table(name="user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// 主键
	private Integer id;
	// 用户名
	private String username;
	// 账号
	private String account;
	// 密码
	private String password;
	// 删除状态0未删除1删除
	private Integer isDelete;

	public User() {

	}

	public User(Integer id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}