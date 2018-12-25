package com.moov.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request")  //在这里写就有点命名空间的意思了
public class RequestMappingController {

	@RequestMapping(value="/mapping",method=RequestMethod.POST)
	public String test(){
		System.out.println("我是一个POST提交");
		return "test";
	}
	
	//method=RequestMethod.GET/POST  访问的方法
	@RequestMapping(value="/mapping2",method=RequestMethod.GET)
	public String test2(){
		System.out.println("我是一个GET提交");
		return "test";
	}
	
	//params="userId"   指明一个参数,如果在params指明了参数名，就必须要添写
	@RequestMapping(value="/mapping3")//开发中不建议写上params={"userId","age"}
	//获取值
	public String test3(@RequestParam("userId")String userId,@RequestParam("age")Integer age){
		System.out.println("我是一个GET提交"+userId+"====="+age);
		return "test";
	}
	
	//params="userId"   指明一个参数,如果在params指明了参数名，就必须要添写
	//工作中經常使用的
	@RequestMapping(value="/mapping4/{username}/{age}")
	public String test4(@PathVariable("username")String username,@PathVariable("age") Integer age){
		System.out.println(username+"===="+age);
		return "test";
	}
}
