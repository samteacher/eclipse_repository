package com.moov.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  统一异常第一种方法
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/handler")
	public String handler(){
		if(2>1){
			throw new  RuntimeException("ddd");
		}
		return "redirect:/success.jsp";
	}
	
	// 统一异常
	@ExceptionHandler(RuntimeException.class)
	public String handlerException(RuntimeException runtimeException){
		return "redirect:/error.jsp";
	}
	
}
