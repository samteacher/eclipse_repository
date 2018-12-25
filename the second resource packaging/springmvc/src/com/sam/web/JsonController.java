package com.sam.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sam.mvc.User;

@Controller
public class JsonController {

	@RequestMapping("/modeltest")
	public ModelAndView model(){
		ModelAndView model = new ModelAndView();
		model.setViewName("jsontest");
		return model;
	}

	@ResponseBody
	@RequestMapping("/jsontest")
	public List<User> test(){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setAge(12);
		user.setUsername("弟弟");
		users.add(user);
		user = new User();
		user.setAge(18);
		user.setUsername("哥哥");
		users.add(user);
		return users;
	}
	
	
}
