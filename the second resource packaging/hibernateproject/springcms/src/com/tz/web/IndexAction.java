package com.tz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 
 * IndexAction<BR>
 * 创建人:潭州学院-keke <BR>
 * 时间：2015年1月18日-上午12:11:29 <BR>
 * @version 1.0.0
 *
 */
@Controller
public class IndexAction {
	
	/**
	 * 后台首页
	 * 方法名：index<BR>
	 * 创建人：潭州学院-keke <BR>
	 * 时间：2015年1月18日-上午12:12:14 <BR>
	 * @return String<BR>
	 * @exception <BR>
	 * @since  1.0.0
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
