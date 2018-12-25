package com.sam.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"/keke/{id}","/keke","/home"})//这种情况很少用
public class RequestMappingController {

	@RequestMapping(value="/mapping",method=RequestMethod.POST)
	public String test(){
		System.out.println("我是一个post提交方法！！");
		return "test";
	}
	
	@RequestMapping(value="/mapping2",params={"userId","age"})
	public String test2(String userId,Integer age){
		System.out.println("我是一个post提交方法！！"+userId+"=========="+age);
		return "test";
	}
	
	//@RequestParam
	//required=true  默认为true，必填的意思
	//defaultValue   默认值
	@RequestMapping(value="/mapping3",params={"userId","age"})
	public String test3(@RequestParam(required=true,value="userId")String userId,@RequestParam("age")Integer age){
		System.out.println("我是一个post提交方法！！"+userId+"=========="+age);
		return "test";
	}
	
	@RequestMapping(value="/mapping4/{userId}/{age}")
	public String test4(@PathVariable("userId")String userId,@PathVariable("age")Integer age,@PathVariable("id")Integer id){
		System.out.println("我是一个post提交方法！！"+userId+"=========="+age+"============"+id);
		return "test";
	}
	
	@RequestMapping(value="/mapping5")
	public String test5(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("username", "小鱼");
		map.put("age", 23);
		request.setAttribute("map", map);
		return "test";
	}
	
	@RequestMapping("/save")
	public ModelAndView save(){
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("username", "小鱼");
		map.put("age", 23);
		modelAndView.addObject("map",map);
		modelAndView.setViewName("index");
		
		System.out.println("===============================");
		return modelAndView;
	}
}
