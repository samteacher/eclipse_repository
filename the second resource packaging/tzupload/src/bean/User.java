/**
 * Project Name:tzupload
 * File Name:User.java
 * Package Name:bean
 * Date:2015��11��6������9:04:29
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015��11��6�� ����9:04:29 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.6
 * @see
 */
public class User {
	// �û�����
	private String username;
	// ����
	private Integer age;
	// ����
	private String email;
	// �绰����
	private String phone;
	// ����
	private String city;
	// ��Ȥ����
	private String[] hobbys;
	private String loves;
	// 1��0Ů2����
	private Integer male;
	/*��������*/
	private Date time;
	// ����
	private String desc;
	
	private Boolean isDelete;

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String[] getHobbys() {
		return hobbys;
	}

	public void setHobbys(String[] hobbys) {
		this.hobbys = hobbys;
	}

	public String getLoves() {
		return loves;
	}

	public void setLoves(String loves) {
		this.loves = loves;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}