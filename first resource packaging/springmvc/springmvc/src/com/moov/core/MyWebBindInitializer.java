package com.moov.core;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.moov.bean.User;

@Controller
public class MyWebBindInitializer implements WebBindingInitializer {
	
	/**
	 * 注册
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Date.class, new DataFormateEditor());
		binder.registerCustomEditor(User.class, new UserEditor());
		binder.registerCustomEditor(Boolean.class, new BooleanEditor());
	}

}
