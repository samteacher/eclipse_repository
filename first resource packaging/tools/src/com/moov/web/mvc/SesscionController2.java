package com.moov.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.moov.bean.User;

/**
 * session方面的知识
 * 这种写法是工作中最为常用的，因为他开发简便
 * SesscionController
 * 创建人:Sam
 * 时间：2017年3月9日-下午3:00:47 
 * @version 1.0.0
 *
 */
@Controller
public class SesscionController2 {
	
	@Autowired
	private ITmContextProvider contextProvider;
	
	@RequestMapping("/login2")
	public String login(){
		User user = new User();
		user.setUsername("林柯达");
		contextProvider.setSessionAttribute("user", user);
		return "forward:index.jsp";
	}
	
	@RequestMapping("/viewsession2")
	public String viewtest(){
		User user  =(User) contextProvider.getSessionAttribute("user");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/updateUser2")
	public String updateUser(){
		User user  =(User) contextProvider.getSessionAttribute("user");
		if(user!=null){
			user.setUsername("柯柯");
		}
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/logout2")
	public String logout(SessionStatus status){
		status.setComplete();
//		contextProvider.removeAttribute("user");
		return "redirect:index.jsp";
	}
	
}
