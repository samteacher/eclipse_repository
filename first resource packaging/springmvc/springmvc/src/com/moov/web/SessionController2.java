package com.moov.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.moov.bean.User;

@Controller
@RequestMapping("/sess")
@SessionAttributes("user")
public class SessionController2 {
	
	@RequestMapping("/success")
	public String success(){
		return "sess/success";
	}

	@RequestMapping("/message")
	public String handler(HttpServletRequest request){
		System.out.println("进入了Message了嘛");
		request.getSession().setAttribute("message", "session ----太爱你了  ");
		return "sess/success";
	}
	
	@RequestMapping("/message2")
	public String handler2(@ModelAttribute("user") User user){
		System.out.println("进入了Message了嘛22222");
		user.setAge(50);
		user.setUsername("小鱼er");
		return "sess/success";
	}
	
}
