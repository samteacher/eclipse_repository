package com.sam.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value="/index1")
	public String test(HttpServletRequest request){
		System.out.println("我的第一个例子！！！"+request.getAttribute("username"));
		return "index";
	}
	
	
	@RequestMapping("/index2")
	public String test2(HttpServletRequest request){
		System.out.println("我的第一个例子！！！");
//		return "redirect:index";
		return "redirect:index.jsp";
//		return "redirect:error.html";
		
//		return "forward:index";
//		return "forward:index.jsp";
//		request.setAttribute("username", "dfads打发第三方 ");
//		return "forward:index";
	}
	
	@RequestMapping("/index3")
	public ModelAndView test3(){
		return new ModelAndView("index");
	}
}
