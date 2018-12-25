package com.moov.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String coursename = request.getParameter("coursename");
		
		System.out.println("login.......");
		
		if(username != null && !username.equals("")){
			if(username.equals("moov") && password.equals("448521")){
				response.sendRedirect("success.html");
			}else {
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}
	
}
