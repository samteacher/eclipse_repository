package com.moov.web;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moov.bean.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/save")
	public String save(){
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
		user.setUsername("我是小鱼");
		user.setPassword("23d4fsa5");
		user.setAge(50);
		//json序列化2
		return JSONUtil.serialize(user);
	}
	
	@ResponseBody
	@RequestMapping("/outUser")
	public User outUser2(){
		User user = new User();
		user.setUsername("我是小鱼");
		user.setPassword("23d4fsa5");
		user.setAge(50);
		return user;
	}
	
}
