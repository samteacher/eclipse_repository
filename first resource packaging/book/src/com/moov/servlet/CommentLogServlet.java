package com.moov.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moov.dao.comment.CommentDao;
import com.moov.util.StringUtil;
/**
 * 评论详情
 * CommentLogServlet
 * 创建人:Sam
 * 时间：2017年2月23日-下午4:19:06 
 * @version 1.0.0
 *
 */
public class CommentLogServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(StringUtil.isNotEmpty(id) && id.matches("\\d")){
			//从服务器取用户id  userid
			HashMap<String, Object> map = (HashMap<String, Object>) request.getSession().getAttribute("user");
			String userid = String.valueOf(map.get("id"));
			//
			HashMap<String, Object> commentMap = CommentDao.getLog(Integer.parseInt(id),Integer.parseInt(userid));
			request.setAttribute("comment", commentMap);
			//跳转页面
			request.getRequestDispatcher("/WEB-INF/page/comment.jsp").forward(request, response);
		}else{
			response.sendRedirect("../404.jsp");
		}
		
	}

	public void destroy() {
		
	}

	public void init(ServletConfig config) throws ServletException {
		
	}

	
}
