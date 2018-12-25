package com.moov.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServletController {

	@Autowired
	private ITmContextProvider contextProvider;
	
	@RequestMapping("/request")
	public String test(HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		String age = request.getParameter("age");
		System.out.println(userId+"===="+age+"====");
		request.setAttribute("age", age);
		return "test";
	}
	
	//这种是最方便的
	@RequestMapping("/request2")
	public String test(){
		System.out.println("===s=s=s=s=s=s="+contextProvider.getRequest().getParameter("userId"));
		return "test";
	}
}
