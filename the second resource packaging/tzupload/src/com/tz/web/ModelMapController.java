/**
 * tzdesk系统平台
 * tzupload
 * com.tz.web
 * ModelMapController.java
 * 创建人:xuchengfei 
 * 时间：2015年11月11日-下午10:30:23 
 * 2015潭州教育公司-版权所有
 */
package com.tz.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import bean.User;

/**
 * 
 * ModelMapController
 * 创建人:xuchengfei 
 * 时间：2015年11月11日-下午10:30:23 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/model")
public class ModelMapController extends BaseController {
	/***********************************参数获取的方式**********************************************/
	///model/hanlder/1
	@RequestMapping("/handler/{id}")
	public String handler(@PathVariable("id")Integer id){
		return "redirect:/success.jsp";
	}
	
	
	@RequestMapping("/handler2")
	public String handler2(Integer id){
		System.out.println(id);
		return "redirect:/success.jsp";
	}
	
	@RequestMapping("/handler3")
	public String handler3(User user){
		System.out.println(user.getUsername());
		return "redirect:/success.jsp";
	}
	
	@RequestMapping("/handler4")
	public String handler4(@ModelAttribute("teacher")User user){
		System.out.println(request.getParameter("id"));
		return "redirect:/success.jsp";
	}
	
	
	/***********************************作用域的问题   reuqest session application 以下：作用域的范围都是：request**********************************************/
	//
	@RequestMapping("/handler7")
	public String handler7(ModelMap map){
		map.addAttribute("message", "我爱你吗。你们爱我我吗");
		return "model/index";
	}
	
	
	@RequestMapping("/handler5")
	public String handler5(){
		request.setAttribute("message", "我爱你吗。你们爱我我吗");
		return "model/index";
	}
	
	@RequestMapping("/handler6")
	public ModelAndView handler6(){
		//视图和作用域融合体
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("model/index");
		modelAndView.addObject("message", "是打发是大法师的发送到发士大夫阿什顿");
		return modelAndView;
	}
	
	@RequestMapping("/handler8")
	public String handler8(@ModelAttribute("user")User user){
		user.setUsername("ModelAttribute 我爱你吗。你们爱我我吗");
		return "model/index";
	}
	
	
}
