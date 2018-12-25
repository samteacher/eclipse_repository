package com.sam.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getServletPath());
		return "forward:index.jsp";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
