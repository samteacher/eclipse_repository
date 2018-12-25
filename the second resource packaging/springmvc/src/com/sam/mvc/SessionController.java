package com.sam.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class SessionController {

	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user){
		user.setUsername("小鱼");
		return "forward:index.jsp";
	}
	
	@RequestMapping("/uploadUser")
	public String uploadUser(ModelMap map){
		User user = (User) map.get("user");
		user.setUsername("小米");
		return "forward:index.jsp";
	}
	
	@RequestMapping("/uploadUser")
	public String uploadHead(ModelMap map){
		map.addAttribute("user", map);
		return "forward:index.jsp";
	}
	
	@RequestMapping("/viewsession")
	public String uploadHead(HttpSession session){
		User user = (User)session.getAttribute("user");
		return "forward:index.jsp";
	}

	
	//********************* 注销用户的两种方式 **************************
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		status.setComplete();
		return "forward:index.jsp";
	}

	@RequestMapping("/logout2")
	public String logout2(HttpServletRequest request){
		request.getSession().invalidate();
		return "forward:index.jsp";
	}
	
}
