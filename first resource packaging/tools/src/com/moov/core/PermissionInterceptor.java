package com.moov.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.moov.bean.User;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		System.out.println("进来了嘛");
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null && user.getUsername().equals("keke")){
			return true;
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("响应已经被渲染成功后执行的方法");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("请求结束执行的方法");
	}

}
