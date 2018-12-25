package com.moov.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   //web层
public class UserController {
	
	@RequestMapping("/index")
	public String test(){
		System.out.println("Helle springmvc 这是我的第一个springmvc案例");
		return "user/test";
	}
	
	@RequestMapping("/allen")
	public String test2(){
		System.out.println("allen同学11111");
		return "test";
	}
	
	@RequestMapping("/allen/save")
	public String test3(){
		System.out.println("allen同学22222");
		return "test";
	}
	
	@RequestMapping("/allen/*/c")
	public String test4(){
		System.out.println("allen同学33333");
		return "test";
	}
	
	@RequestMapping("/allen/**/c")
	public String test5(){
		System.out.println("allen同学33333");
		return "test";
	}
	
	@RequestMapping("/allen/?/c")
	public String test6(){
		System.out.println("allen同学33333");
		return "test";
	}
}
