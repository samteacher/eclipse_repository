package com.moov.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.moov.bean.User;

@Controller
public class ModelController {

	@RequestMapping(value="/model/{111}/{your}",method=RequestMethod.POST)
	public String test(User user){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAge());
		return "test";
	}
}
