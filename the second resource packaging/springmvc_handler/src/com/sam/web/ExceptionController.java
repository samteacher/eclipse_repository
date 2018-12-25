package com.sam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统一异常
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/handler")
	public String handler(){
		try {
			System.out.println(1/0);
			return "redirect:/index.jsp";
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
	
	/*
	 * 第一种异常处理方式
	 */
//	@ExceptionHandler(RuntimeException.class)
//	public String handlerException(RuntimeException runtimeException){
//		return "redirect:/error.jsp";
//	}
}
