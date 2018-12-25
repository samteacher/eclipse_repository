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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bean.User;

/**
 * 
 * ModelMapController
 * 创建人:xuchengfei 
 * 时间：2015年11月11日-下午10:30:23 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/session")
public class SessionCotroller extends BaseController {
	
	/*如果@SessionAttributes没有user属性的时候,方法的@ModelAttribute先调用 会调用一个指明：@ModelAttribute隐式的对象创建，
	 * 第一步
	 * 对象创建成功以后在赋给 @SessionAttributes("user")
	 * 第二步：
	 * User user = new User(); 
	 * @ModelAttribute("user")
		public User getUser(){
			return new User();
		}
		session.setAttribute("user",user);
		
		//3
		User user = (User)session.getAttribute("user");
		@ModelAttribute("user") User user
	 * 
	 * 
	 * */
	
	
	@RequestMapping(value={"/success","/success2"})
	public String success(){
		return "session/success";
	}
	
	///model/hanlder/1
	@RequestMapping("/handler")
	public String handler(){
		request.getSession().setAttribute("cmessage", "session ---太爱你了!");
		return "redirect:success.html";
	}
	
//	org.springframework.web.HttpSessionRequiredException: Session attribute 'user' required - not found in session
	@RequestMapping("/handler2")
	public String handler2(@ModelAttribute("user") User user){
		user.setUsername("威威是一个小帅哥.");
		user.setAge(16);
		return "session/index";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user){
		user.setUsername("威威是一个小帅哥,同有钱....");
		user.setAge(16);
		return "session/index";
	}
	
	
	/************************注销会话*******************************************/
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();//清除所有的会话
//		session.removeAttribute("user");
		return "session/success";
	}
	
	@RequestMapping("/logout2")
	public String logout2(ModelMap modelMap,SessionStatus sessionStatus){
		User user = (User)modelMap.get("user");
		if(user!=null){
			sessionStatus.setComplete();//清除所有的会话
		}
		return "session/success";
	}
	
	/*application的获取*/
	
//	@RequestMapping("/application")
//	public String application(ServletContext context){
//		System.out.println(context);
//		return "ok";
//	}
	
//	@RequestMapping("/application")
//	public String application(){
//		request.getServletContext();
//		return "ok";
//	}
//	
}
