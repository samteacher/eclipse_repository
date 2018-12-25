package com.sam.bean;

import java.util.Date;

public class AdminUser {

	private Integer id;
	private String username;
	private String account;
	private String password;
	private Date createTime;
	private Date updateTime;
	private String email;
	private String telephone;
	private Integer age;
	private String address;
	private Date birthday;
	private String handerPic;
	private Integer isDelete;
	private Integer male;
	private Integer forbidden;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHanderPic() {
		return handerPic;
	}

	public void setHanderPic(String handerPic) {
		this.handerPic = handerPic;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Integer getForbidden() {
		return forbidden;
	}

	public void setForbidden(Integer forbidden) {
		this.forbidden = forbidden;
	}

	public AdminUser() {
		super();
	}

	public AdminUser(Integer id, String username, String account,
			String password, Date createTime, Date updateTime, String email,
			String telephone, Integer age, String address, Date birthday,
			String handerPic, Integer isDelete, Integer male, Integer forbidden) {
		super();
		this.id = id;
		this.username = username;
		this.account = account;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.email = email;
		this.telephone = telephone;
		this.age = age;
		this.address = address;
		this.birthday = birthday;
		this.handerPic = handerPic;
		this.isDelete = isDelete;
		this.male = male;
		this.forbidden = forbidden;
	}

}
