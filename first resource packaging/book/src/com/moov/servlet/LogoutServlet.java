package com.moov.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//注销session
		request.getSession().invalidate();
		Cookie cookie = new Cookie("user_key", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		//需要注册所有的cookie
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie2 : cookies) {
//			cookie2.setMaxAge(0);
//			response.addCookie(cookie2);
//		}
		
		response.sendRedirect("login.jsp");
		
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}

	
}
