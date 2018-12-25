package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moov.bean.User;

@Controller
@RequestMapping("users")
public class AjaxController {

	@ResponseBody
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public String saveUser(User user){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAge());
		System.out.println(user.getEmail());
		return "success";
	}
	
}
