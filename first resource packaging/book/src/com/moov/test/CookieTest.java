package com.moov.test;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if("username".equals(cookie.getName())){
					String uname = URLDecoder.decode(cookie.getValue(),"UTF-8");
					System.out.println("浏览器获取的cookie的信息是"+uname);
				}
			}
		}

		
		String username = URLEncoder.encode("余秋富","UTF-8");
		Cookie cookie = new Cookie("username", username);
		
		cookie.setMaxAge(500);
		response.addCookie(cookie);
		
		//清空cookie
		cookie.setMaxAge(0);
		
	}

	public void destroy() {
	}

	public void init() throws ServletException {
	}

}
