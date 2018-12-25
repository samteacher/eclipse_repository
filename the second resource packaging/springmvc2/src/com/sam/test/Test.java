package com.sam.test;

import java.util.Date;

import javax.servlet.annotation.WebInitParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sam.dao.User;
import com.sam.util.DateFormateEditor;

/**
 * 两种方式
 * @author Administrator
 *
 */
@Controller
public class Test {

	@RequestMapping("/login")
	public String test(){
		return "login";
	}
	
	@InitBinder
	public void initDate(WebDataBinder dataBinder){
		System.out.println("进入了InitBinder~!!!!!!!");
		dataBinder.registerCustomEditor(Date.class, new DateFormateEditor());
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(User user){
		System.out.println(user.getUsername());
		return "redirect:index.jsp";
	}
}
