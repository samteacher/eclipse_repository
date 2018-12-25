/**
 * tzdesk系统平台
 * tzupload
 * com.tz.web
 * ExceptionController.java
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午10:51:38 
 * 2015潭州教育公司-版权所有
 */
package com.tz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * ExceptionController
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午10:51:38 
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
