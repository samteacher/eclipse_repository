/**
 * tzdeskϵͳƽ̨
 * tzupload
 * com.tz.web
 * ExceptionController.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��13��-����10:51:38 
 * 2015̶�ݽ�����˾-��Ȩ����
 */
package com.tz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * ExceptionController
 * ������:xuchengfei 
 * ʱ�䣺2015��11��13��-����10:51:38 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController  extends BaseController{

	
	@RequestMapping("/handler")
	public String handler(){
		try {
			System.out.println(1/0);
			return "redirect:/success.jsp";
		} catch (RuntimeException ex) {
			throw ex;
		}
	}
	
	
}
