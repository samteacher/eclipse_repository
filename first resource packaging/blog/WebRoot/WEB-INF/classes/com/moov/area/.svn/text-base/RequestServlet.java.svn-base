package com.moov.area;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("username", "宫丽");
		request.setAttribute("password", 7777);
		
		PrintWriter out = response.getWriter();
		out.print("<h1>设值成功！！！！</h1>");
		
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
	}

	public void destroy() {
	}

	public void init() throws ServletException {
	}
	
}
