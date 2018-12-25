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

import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import bean.User;

import com.tz.util.DateEditor;

/**
 * 
 * ModelMapController
 * 创建人:xuchengfei 
 * 时间：2015年11月11日-下午10:30:23 
 * @version 1.0.0
 */
@Controller
@RequestMapping("/kdate")
public class KDateController extends BaseController {
	
//	@InitBinder
//	protected void initBinder(HttpServletRequest request,
//	                              ServletRequestDataBinder binder) throws Exception {
//	    //对于需要转换为Date类型的属性，使用DateEditor进行处理
//	    binder.registerCustomEditor(Date.class, new DateEditor());
//	}
	
	
	@RequestMapping("/handler")
	public String save(User user){
		System.out.println(user);
		return "";
	}
	
}
