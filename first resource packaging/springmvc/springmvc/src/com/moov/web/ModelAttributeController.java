package com.moov.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import com.moov.bean.User;

@Controller
public class ModelAttributeController {

	@RequestMapping("/attirbute")
	public String test(@ModelAttribute("user") User user){
		System.out.println("========"+user.getAge()+"==="+user.getPassword());
		return "forward:index.jsp";
	}
	
	@RequestMapping("/attirbute2")
	public String test2(User user){
		System.out.println("********"+user.getAge()+"==="+user.getPassword());
		return "forward:index.jsp";
	}
	
	@RequestMapping("/attirbute3")
	public String test2(HttpServletRequest request){
		String age = WebUtils.findParameterValue(request, "age");
		String password = WebUtils.findParameterValue(request, "password");
		System.out.println("********"+age+"==="+password);
		return "forward:index.jsp";
	}
	
	@RequestMapping("/attirbute4")
	public String test2(WebRequest request){
		String age = request.getParameter("age");
		String password = request.getParameter("password");
		System.out.println("********"+age+"==="+password);
		return "forward:index.jsp";
	}
	
}
