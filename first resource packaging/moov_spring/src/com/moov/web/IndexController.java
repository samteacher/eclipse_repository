package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		System.out.println("Ok");
		return "index";
	}
	
}
