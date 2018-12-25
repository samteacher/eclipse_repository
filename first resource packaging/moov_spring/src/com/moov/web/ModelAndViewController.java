package com.moov.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.moov.bean.User;

@Controller
public class ModelAndViewController {

	@RequestMapping("/hashmap")
	public String hashMap(User user,HttpServletRequest request){
		System.out.println("test..............");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		map.put("age", user.getAge());
		map.put("email", user.getEmail());
		request.setAttribute("map", map);
		return "test";
	}
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> list = new ArrayList<User>();
		User user =  new User();
		user.setUsername("dlskfajdfjl");
		user.setPassword("4d56fas4d5fsa");
		user.setAge(28);
		user.setEmail("11111@qq.com");
		list.add(user);
		modelAndView.addObject("list",list);
		modelAndView.setViewName("test");
		return modelAndView;
	}
	
	@RequestMapping("/view")
	public String view(WebRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		return "test";
	}
	
	@RequestMapping("/request")
	public String request(HttpServletRequest request){
		String username = WebUtils.findParameterValue(request, "username");
		String password = WebUtils.findParameterValue(request, "password");
		String age = WebUtils.findParameterValue(request, "age");
		String email = WebUtils.findParameterValue(request, "email");
		System.out.println("====="+username+"==="+password+"==="+age+"==="+email);
		return "test";
	}
	
	@RequestMapping("/getuser")
	public String getuser(User user){
		System.out.println(user.getUsername()+user.getPassword()+user.getAge()+user.getEmail());
		return "test";
	}
	
	@RequestMapping("/mapping/{username}/{password}")
	public String mapping(@PathVariable("username")String username,@PathVariable("password")String password){
		System.out.println(username+"====="+password);
		return "test";
	}
	
}
