/**
 * Project Name:tzupload
 * File Name:BaseController.java
 * Package Name:com.tz.core
 * Date:2015年11月9日下午10:58:43
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.tz.web;


import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import bean.User;

import com.tz.core.ITmContextProvider;
import com.tz.util.DateFormateEditor;

/**
 * ClassName:BaseController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月9日 下午10:58:43 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Controller
@SessionAttributes(value={"user","teacher"})
public class BaseController {
	
	
	@Autowired
	protected ITmContextProvider contextProvider;
	//第一种：获取通用的请求对对象的方式
//	@Autowired
//	protected HttpServletResponse response;
//	@Autowired
//	protected HttpServletRequest request;
	
	//第二种
	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected HttpSession session;
	
	@ModelAttribute  
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response,HttpSession session){  
	    this.response= response;  
	    this.request = request;
	    this.session = session;
	}
	
	
	
	/*统一处理日期格式化的问题*/
	@InitBinder
	public void initDataBinder(WebDataBinder dataBinder){
		dataBinder.registerCustomEditor(Date.class, new DateFormateEditor());
	}
	
	/*统一异常处理*/
//	@ExceptionHandler(RuntimeException.class)
//	public String handlerException(RuntimeException runtimeException){
//		return "redirect:/error.jsp";
//	}
	
//	/*统一异常处理*/
//	@ExceptionHandler(NullPointerException.class)
//	public String hand(RuntimeException runtimeException){
//		return "redirect:/nulll.jsp";
//	}
	
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	
	@ModelAttribute("teacher")
	public User getTeacher(){
		return new User();
	}
		
	/**
	 * @author Administrator
	 * @param obj
	 * @since JDK 1.6
	 */
	public void jsonToString(Object obj){
		try {
			contextProvider.setResponse(response);
			PrintWriter writer = contextProvider.getResponse().getWriter();
//			PrintWriter writer = response.getWriter();
			writer.print(JSONUtil.serialize(obj));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

