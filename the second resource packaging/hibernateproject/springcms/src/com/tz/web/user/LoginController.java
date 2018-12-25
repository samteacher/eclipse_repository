package com.tz.web.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.entity.User;
import com.tz.service.UserService;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/logined")
	public String logined(HttpServletRequest request){
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = userService.getUser(account, password);
		if(user!=null){
			return "success";
		}else{
			return "fail";
		}
	}
}
