package com.sam.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("/index")
	public String login(HttpServletRequest request){
		System.out.println("1111111"+request.getContextPath());
		System.out.println("2222222"+request.getRequestURI());
		System.out.println("333333"+request.getRequestURL());
		System.out.println("4444"+request.getServletPath());
		return "forward:index.jsp";
	}
	
	@RequestMapping("/index1")
	public String index(){
		return "index";
	}
	
}
