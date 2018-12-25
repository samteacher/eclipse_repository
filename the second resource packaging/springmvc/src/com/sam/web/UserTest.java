package com.sam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sam.mvc.User;

@Controller
public class UserTest {


	@RequestMapping("/user")
	public String test(User user){
		System.out.println("名稱===="+user.getUsername()+"=====年齡===="+user.getAge());
		return "index";
	}
	
}
