/**
 * tzdeskϵͳƽ̨
 * tzupload
 * com.tz.web
 * ModelMapController.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��11��-����10:30:23 
 * 2015̶�ݽ�����˾-��Ȩ����
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
 * ������:xuchengfei 
 * ʱ�䣺2015��11��11��-����10:30:23 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/model")
public class ModelMapController extends BaseController {
	/***********************************������ȡ�ķ�ʽ**********************************************/
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
	
	
	/***********************************�����������   reuqest session application ���£�������ķ�Χ���ǣ�request**********************************************/
	//
	@RequestMapping("/handler7")
	public String handler7(ModelMap map){
		map.addAttribute("message", "�Ұ��������ǰ�������");
		return "model/index";
	}
	
	
	@RequestMapping("/handler5")
	public String handler5(){
		request.setAttribute("message", "�Ұ��������ǰ�������");
		return "model/index";
	}
	
	@RequestMapping("/handler6")
	public ModelAndView handler6(){
		//��ͼ���������ں���
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("model/index");
		modelAndView.addObject("message", "�Ǵ��Ǵ�ʦ�ķ��͵���ʿ���ʲ��");
		return modelAndView;
	}
	
	@RequestMapping("/handler8")
	public String handler8(@ModelAttribute("user")User user){
		user.setUsername("ModelAttribute �Ұ��������ǰ�������");
		return "model/index";
	}
	
	
}
