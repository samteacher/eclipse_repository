package com.sam.util;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 转换中心
 */
public class MyWebBindInitializer implements WebBindingInitializer{

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		binder.registerCustomEditor(Date.class, new DateFormateEditor());
	}

}
