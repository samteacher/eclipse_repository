package com.moov.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.moov.bean.User;

/**
 * session方面的知识
 * 
 * SesscionController
 * 创建人:Sam
 * 时间：2017年3月9日-下午3:00:47 
 * @version 1.0.0
 *
 */
@Controller
@SessionAttributes("user")  //同步session
public class SesscionController {
	
	//初始化一次，否则会出bug
	//如果@SessionAttributesion没有这具属性的时候，就会报错
	@ModelAttribute("user")
	public User getUser(){
		System.out.println("第一次会进来初始化我哦，因为session需要我");
		return new User();
	}

//	@RequestMapping("/login")
//	public String login(@ModelAttribute("user") User user){
//		user.setUsername("大米");
//		return "forward:index.jsp";
//	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user){
		if(user!=null){
			user.setUsername("大米");
		}
		return "forward:index.jsp";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(ModelMap map){
		User user  =(User) map.get("user");
		if(user!=null){
			user.setUsername("柯柯1111111");
		}
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/updateHead")
	public String updateHeaderPic(ModelMap map){
		User user  =(User) map.get("user");
		if(user!=null){
			user.setUsername("柯柯222222");
		}
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		status.setComplete();  //加上它就是退出的意思
		return "redirect:index.jsp";
		
	}
	
	@RequestMapping("/logout2")
	public String logout2(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:index.jsp";
		
	}
	
}
