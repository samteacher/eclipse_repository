package com.sam.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
	
	@RequestMapping("/testResponseBody")
	@ResponseBody
	public String testResponseBody(HttpServletRequest request){
	    return "<h1 style='color:lightGreen'>Hello Web!</h1>";
	}
}
