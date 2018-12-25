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
 * ������:xuchengfei 
 * ʱ�䣺2015��11��11��-����10:30:23 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/session")
public class SessionCotroller extends BaseController {
	
	/*���@SessionAttributesû��user���Ե�ʱ��,������@ModelAttribute�ȵ��� �����һ��ָ����@ModelAttribute��ʽ�Ķ��󴴽���
	 * ��һ��
	 * ���󴴽��ɹ��Ժ��ڸ��� @SessionAttributes("user")
	 * �ڶ�����
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
		request.getSession().setAttribute("cmessage", "session ---̫������!");
		return "redirect:success.html";
	}
	
//	org.springframework.web.HttpSessionRequiredException: Session attribute 'user' required - not found in session
	@RequestMapping("/handler2")
	public String handler2(@ModelAttribute("user") User user){
		user.setUsername("������һ��С˧��.");
		user.setAge(16);
		return "session/index";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user){
		user.setUsername("������һ��С˧��,ͬ��Ǯ....");
		user.setAge(16);
		return "session/index";
	}
	
	
	/************************ע���Ự*******************************************/
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();//������еĻỰ
//		session.removeAttribute("user");
		return "session/success";
	}
	
	@RequestMapping("/logout2")
	public String logout2(ModelMap modelMap,SessionStatus sessionStatus){
		User user = (User)modelMap.get("user");
		if(user!=null){
			sessionStatus.setComplete();//������еĻỰ
		}
		return "session/success";
	}
	
	/*application�Ļ�ȡ*/
	
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
