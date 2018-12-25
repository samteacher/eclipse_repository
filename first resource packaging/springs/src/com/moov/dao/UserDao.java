package com.moov.dao;

/**
 * 用户实体层 User 创建人:Sam 时间：2017年2月28日-下午10:11:28
 * 
 * @version 1.0.0
 * 
 */
public class UserDao {

	private String bank;
	protected String color;
	String name;
	public int sheep;

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSheep() {
		return sheep;
	}

	public void setSheep(int sheep) {
		this.sheep = sheep;
	}

}
