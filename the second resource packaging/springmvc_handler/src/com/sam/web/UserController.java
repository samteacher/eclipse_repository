/**
 * tzdesk系统平台
 * springmvc2
 * com.tz.web
 * UserController.java
 * 创建人:xuchengfei 
 * 时间：2015年11月16日-下午9:35:31 
 * 2015潭州教育公司-版权所有
 */
package com.sam.web;

import java.util.Date;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.dao.User;


/**
 * 
 * UserController
 * 创建人:xuchengfei 
 * 时间：2015年11月16日-下午9:35:31 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/add")
	public String add(){
		return "user/add";
	}
	
	@RequestMapping("/json")
	public String json(){
		return "user/json";
	}
	
	@ResponseBody
	@RequestMapping("/out")
	public String outUser() throws JSONException{
		User user = new User();
		user.setUsername("keke");
		user.setPhone("15074816437");
		user.setEmail("761008250@qq.com");
		user.setTime(new Date());
		user.setDesc("我是柯柯");
		return JSONUtil.serialize(user);
	}
	
	
	@ResponseBody
	@RequestMapping("/outUser")
	public User outUser2(){
		User user = new User();
		user.setUsername("keke");
		user.setPhone("15074816437");
		user.setEmail("761008250@qq.com");
		user.setTime(new Date());
		user.setDesc("我是柯柯");
		return user;
	}
}
