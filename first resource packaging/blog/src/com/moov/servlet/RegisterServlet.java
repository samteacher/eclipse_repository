package com.moov.servlet;

import java.io.IOException;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moov.util.StringUtil;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		if(StringUtil.isNotEmpty(username) && username.equals("moov")){
			request.getRequestDispatcher("success.html").forward(request, response);
//			request.getRequestDispatcher("forword").forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
	
	}

	public void destroy() {
		System.out.println("进入destroy");
	}

	public void init() throws ServletException {
		
	}
}
