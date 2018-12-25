package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		System.out.println("ok");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("这里是Logo");
		return "login";
	}
}
