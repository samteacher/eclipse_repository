package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.moov.bean.User;

@Controller
@SessionAttributes("user")
public class SessionController {
	
	@ModelAttribute("user")
	public User getUser(){
		System.out.println("第一次会进来初始化我哦，因为session需要我");
		return new User();
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user){
		if(user!=null){
			user.setUsername("余秋富");
		}
		return "forward:login.jsp";
	}

	@RequestMapping("/update")
	public String update(ModelMap map){
		User user = (User) map.get("user");
		if(user!=null){
			user.setUsername("余秋富111111");
		}
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/updateHead")
	public String updateHead(ModelMap map){
		User user = (User) map.get("user");
		if(user!=null){
			user.setUsername("余秋富222222");
		}
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		status.setComplete();
		return "redirect:login.jsp";
	}
}
