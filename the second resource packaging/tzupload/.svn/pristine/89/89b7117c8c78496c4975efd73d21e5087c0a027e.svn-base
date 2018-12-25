/**
 * Project Name:tzupload
 * File Name:TzUploadController.java
 * Package Name:tzupload
 * Date:2015年11月5日下午9:09:13
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.tz.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName:TzUploadController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月5日 下午9:09:13 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.6
 * @see
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	
	@RequestMapping("/index") 
	public String index(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("name", "xingxing");
		map.put("age", 16);
		request.setAttribute("map", map);
		return "zhangsan/upload/keke";
	}
	
	//如果数据的存放到作用域中你可以string
	
	@RequestMapping(value="/save")
	public ModelAndView save(){
		ModelAndView modelAndView = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("name", "xingxing");
		map.put("age", 16);
		modelAndView.addObject("map", true);//request.setAttribute("map", map);
		modelAndView.setViewName("zhangsan/upload/keke");
		return modelAndView;
	}
	
	@RequestMapping("/update") 
	public String index(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String,Object>();
		String username = request.getParameter("username");
		System.out.println("============="+username);	
		map.put("name", "xingxing");
		map.put("age", 16);
		request.setAttribute("map", map);
		return "zhangsan/upload/keke";
	}
	
	
	@RequestMapping("/success")
	public String success(){
		return "common/success";
	}
	
	@RequestMapping("/keke/responsepage") 
	public String respage(HttpServletRequest request){
		HashMap<String, Object> map = new HashMap<String,Object>();
		String username = request.getParameter("username");
		System.out.println("============="+username);	
		map.put("name", "xingxing");
		map.put("age", 16);
		request.setAttribute("map", map);
		//return "redirect:success.html?username=keke";
		return "redirect:/success.jsp";//如果/就代项目表根目录
		//重定向一定是webroot下面的页面或者是requestMapping路径
	}

}
