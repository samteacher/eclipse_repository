package com.sam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sam.mvc.User;

@Controller
public class ModelAttributeController {
	
	@RequestMapping("getuser")
	public String getuser(User user){
		System.out.println(user.getUsername()+"========="+user.getAge());
		return "index";
	}

	@RequestMapping("model")
	public String model(@ModelAttribute("user") User user){
		System.out.println(user.getUsername()+"========="+user.getAge());
		return "index";
	}
	
}
