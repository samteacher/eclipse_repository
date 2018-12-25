package com.moov.area;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = (String) this.getServletContext().getAttribute("username");
		Integer password = (Integer) this.getServletContext().getAttribute("password");
		PrintWriter out = response.getWriter();
		out.println("<h1>application返回的===="+username+"=="+password+"</h1>");
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}
	
}
