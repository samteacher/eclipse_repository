package com.moov.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moov.dao.user.UserDao;
import com.moov.util.StringUtil;
/**
 * 登录拦截
 * LoginFilter
 * 创建人:Sam
 * 时间：2017年2月23日-下午12:22:38 
 * @version 1.0.0
 *
 */
public class LoginFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HashMap<String, Object> sessionMap = (HashMap<String, Object>) request.getSession().getAttribute("user");
		
		if(sessionMap==null){
			
			Cookie[] cookies = request.getCookies();
			String username = null;
			for (Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase("user_key")){
					username = cookie.getValue();
					break;
				}
			}
			//根据帐户去数据表中查询
			if(StringUtil.isNotEmpty(username)){
				sessionMap = UserDao.findUser(username);
				if(sessionMap!=null){
					request.getSession().setAttribute("user", sessionMap);
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else {
					response.sendRedirect(request.getContextPath()+"/login.jsp");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}else {
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
