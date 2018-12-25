package com.moov.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.moov.bean.User;

/**
 * ModelAndView
 * ModelAndViewController
 * 创建人:Sam
 * 时间：2017年3月9日-下午2:01:21 
 * @version 1.0.0
 *
 */
@Controller
@SessionAttributes("user")
public class ModelAndViewController {

	private ITmContextProvider contextProvider;
	
	//spring mvc不限方法返回类型，ModelAndView
	@RequestMapping("/view")
	public ModelAndView test(){
		ModelAndView modelAndView = new ModelAndView();
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setAge(40);
		user.setUsername("小鱼");
		user.setPassword("12345");
		users.add(user);
		//数据的添加
//		modelAndView.addObject("user",user);
		modelAndView.addObject(user);
		modelAndView.addObject("users",users);
		//返回页面视图
		modelAndView.setViewName("forward:index.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/modelsession")
	public void view(ModelMap map){
		User user = (User) map.get("user");
		User user2 = (User) contextProvider.getSessionAttribute("user");
		System.out.println(user.getUsername());
	}
	
	
}