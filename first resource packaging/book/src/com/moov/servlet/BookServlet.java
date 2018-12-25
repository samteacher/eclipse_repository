package com.moov.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.moov.dao.log.MoLogDao;

public class BookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HashMap<String, Object> map = (HashMap<String, Object>) request.getSession().getAttribute("user");
		List<HashMap<String, Object>> logMaps = MoLogDao.findLogs(Integer.parseInt(String.valueOf(map.get("id"))));
		request.setAttribute("logMaps", logMaps);
		request.getRequestDispatcher("/WEB-INF/page/book.jsp").forward(request, response);
		
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}
	
	
}
