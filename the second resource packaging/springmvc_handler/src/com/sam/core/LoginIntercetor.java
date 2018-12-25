package com.sam.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sam.dao.User;

/**
 * springmvc拦截器   
 * HandlerInterceptor 
 * @author Administrator
 *
 */
public class LoginIntercetor implements HandlerInterceptor {

	/*
	 * return true;为true的时候才会继续往下执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		
		System.out.println("进来了嘛......");
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null ){
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/index");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("请求结束执行的方法......");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("响应已经被渲染成功后执行的方法......"); 
	}

}
