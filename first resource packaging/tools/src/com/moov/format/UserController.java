package com.moov.format;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc类型转换
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 统一处理日期格式化的问题
	 * @param dataBinder
	 */
	@InitBinder
	public void initDate(WebDataBinder dataBinder){
		dataBinder.registerCustomEditor(Date.class, new DataFormateEditor());
	}
}
