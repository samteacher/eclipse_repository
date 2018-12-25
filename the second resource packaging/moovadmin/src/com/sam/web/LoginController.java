package com.sam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sam.bean.AdminUser;
import com.sam.bean.User;
import com.sam.core.BaseController;
import com.sam.service.IAdminUserService;
import com.sam.service.IUserService;
import com.sam.util.StringUtil;

import static com.sam.util.TzConstant.*;

@Controller
public class LoginController extends BaseController {

	//@Autowired
	//private IUserService service;

	@Autowired
	private IAdminUserService service;
	
	@RequestMapping("/login")
	public String getLogin(){
		return "login";
	}
	
	/**
	 * 登录方法
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(AdminUser user){
		if(user!=null){
			if(StringUtil.isNotEmpty(user.getUsername()) && StringUtil.isNotEmpty(user.getPassword())){
				user.setUsername(user.getUsername());
				user.setPassword(user.getPassword());
				AdminUser users = service.getLogin(user);
				if(users!=null){
					if(users.getForbidden() == 0){
						return "forbidden";
					}else {
						session.setAttribute(SESSION_USER, users);
						session.setAttribute(SESSION_USER_NAME, users.getAccount());
					}
					return "success";
				}else {
					return "fail";
				}
			}else {
				//请输入帐号和密码
				return "null";
			}
			
		}else{
			return "error";
		}
	}
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	/**
	 * 退出 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "login";
	}
	
}
