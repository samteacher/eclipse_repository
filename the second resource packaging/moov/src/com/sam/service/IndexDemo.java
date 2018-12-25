package com.sam.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexDemo {

	@RequestMapping("/getValue")
	public String index(){
		return "value";
	}
	
	@RequestMapping(value="/getParms/?/c")
	public String getParms(String userId){
		System.out.println("进来了"+userId);
		return "value";
	}
	
	@RequestMapping("/getRequest")
	public String getRequest(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("进来了"+"---"+username+"----"+password);
		return "value";
	}
	
	@RequestMapping("/getModelAndView")
	public ModelAndView getModelAndView(HashMap<String, String> maps){
		ModelAndView model = new ModelAndView();
		HashMap<String, String> map = new HashMap<>();
		map.put("username", "dfasdf");
		map.put("password", "564f5as4d6fa");
		model.addObject("map", map);
		model.setViewName("value");
		return model;
	}
	
	
}
