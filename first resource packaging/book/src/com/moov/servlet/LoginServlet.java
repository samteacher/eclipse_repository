package com.moov.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moov.dao.user.UserDao;
import com.moov.util.ConnectionUtil;
import com.moov.util.StringUtil;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//获取cookie标识
		String cookieMark = request.getParameter("sign");
		PrintWriter out = response.getWriter();
		if(StringUtil.isNotEmpty(account) && StringUtil.isNotEmpty(password)){
			HashMap<String, Object> map = ConnectionUtil.findUser(account, password);
			if(map==null){
				Cookie[] cookies = request.getCookies();
				if(cookies!=null && cookies.length > 0){
					String username = null;
					for (Cookie cookie : cookies) {
						if(cookie.getName().equalsIgnoreCase("user_key")){
							username = cookie.getValue();
							break;
						}
					}
					//根据帐户去数据表中查询
					if(StringUtil.isNotEmpty(username)){
						map = UserDao.findUser(username);
						if(map!=null){
							request.getSession().setAttribute("user", map);
							out.print("success");
						}else {
							out.print("fail");
						}
					}
				}else {
					out.print("fail");
				}
			}else {
				request.getSession().setAttribute("user", map);
				out.print("success");
				//如果页面选择了免七天登录
				if(StringUtil.isNotEmpty(cookieMark) && "1".equalsIgnoreCase(cookieMark)){
					Cookie cookie = new Cookie("user_key", account);
					response.addCookie(cookie);
					cookie.setMaxAge(7*60*60*24);
				}else {
					
				}
			}
		}else {
			out.print("fail");
		}
		out.flush();
		out.close();
	}

	public void destroy() {
		
	}

	public void init() throws ServletException {
		
	}

}
