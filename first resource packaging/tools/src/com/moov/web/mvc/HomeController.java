package com.moov.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping
	public String home(){
		System.out.println("进入首页");
		return "forward:index.jsp";//浏览器地址不变
//		return "redirect:index.jsp";
	}
}