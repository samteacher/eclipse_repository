package com.moov.area;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessiconTest extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessicontest = request.getSession();
		String username = (String) sessicontest.getAttribute("username");
		Integer password = (Integer) sessicontest.getAttribute("password");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>sessicon作用域返回的值==="+username+"====="+password+"</h1>");
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}

	
}
