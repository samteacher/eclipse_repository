package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	@RequestMapping("/moov")
	public String man(){
		System.out.println("进入首页");
		return "test";
	}
	
	@RequestMapping("/moov2")
	public String froword(){
		System.out.println("进入首页222222");
//		return "forword:index";
		return "forward:error.html";
	}
	
	@RequestMapping("/moov3")
	public String redirect(){
		System.out.println("进入首页33333");
//		return "redirect:user/test";   //
//		return "redirect:index.jsp";
//		return "redirect:error.html";
		return "redirect:moov";
	}
	
}
