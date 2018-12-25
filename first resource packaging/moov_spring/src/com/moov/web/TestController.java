package com.moov.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", "moov");
		map.put("password", "123456");
		map.put("age", 22);
		request.setAttribute("map", map);
		return "test";
	}
	
	/**
	 * 这两个的结果是一样的。第二个是使用了ModelAndView  不用request了
	 */
	
	@RequestMapping("/save")
	public ModelAndView save(){
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", "moov");
		map.put("password", "123456");
		map.put("age", 22);
		modelAndView.addObject("map",map);
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String index(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		request.setAttribute("age", age);
		return "test";
	}
	
}
