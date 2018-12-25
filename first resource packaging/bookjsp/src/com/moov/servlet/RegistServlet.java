package com.moov.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void destroy() {
		
	}

	public void init(ServletConfig config) throws ServletException {
		//context-param
//		String username = config.getServletContext().getInitParameter("content");
//		System.out.println(username);
		
		//servlet-param
 		String username = config.getInitParameter("content");
		System.out.println(username);
	}

	
	
}
