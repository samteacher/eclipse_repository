package com.sam.entity.OneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tyuser", catalog = "hibernatetest")
public class TyUser implements java.io.Serializable {

	private Integer id;
	private String name;
	private String password;
	
	// 配置单向的
	private UserChildren userChildren;

	public TyUser() {
		super();
	}

	public TyUser(Integer id) {
		this.id = id;
	}

	public TyUser(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//fetch=FetchType.LAZY 懒加载
	//cascade = CascadeType.ALL 级联
	//mappedBy="user" 双向才有意义，单向没有任何意义
	//双向里面一定是用mappedBy
	@OneToOne(targetEntity = UserChildren.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="user")
	public UserChildren getUserChildren() {
		return userChildren;
	}

	public void setUserChildren(UserChildren userChildren) {
		this.userChildren = userChildren;
	}

}
