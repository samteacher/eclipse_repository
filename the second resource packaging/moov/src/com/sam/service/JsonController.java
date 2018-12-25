package com.sam.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.test.User;

@Controller
public class JsonController {

	@ResponseBody
	@RequestMapping("josntest")
	public User test(){
		User user = new User();
		user.setUsername("dfasd");
		user.setAge(11);
		return user;
	}
}
