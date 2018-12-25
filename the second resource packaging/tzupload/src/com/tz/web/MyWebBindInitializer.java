package com.tz.web;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import bean.User;

import com.tz.util.DateFormateEditor;
import com.tz.util.BooleanEditor;

@Component
public class MyWebBindInitializer implements WebBindingInitializer{

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
//		binder.registerCustomEditor(Date.class, new DateEditor());
		//Integer Float Byte Short Long Boolean  
		binder.registerCustomEditor(Date.class, new DateFormateEditor());
//		binder.registerCustomEditor(Boolean.class, new BooleanEditor());
	}


}
