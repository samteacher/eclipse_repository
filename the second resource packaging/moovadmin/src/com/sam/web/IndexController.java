/**
 * tzdesk系统平台
 * moovip_admin
 * com.tz.web
 * IndexController.java
 * 创建人:xuchengfei 
 * 时间：2015年11月23日-下午11:46:36 
 * 2015潭州教育公司-版权所有
 */
package com.sam.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * IndexController
 * 创建人:xuchengfei 
 * 时间：2015年11月23日-下午11:46:36 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
