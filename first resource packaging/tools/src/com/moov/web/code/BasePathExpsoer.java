package com.moov.web.code;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
/**
 * 绝对路径解决方案二
 * @author Administrator
 *
 */
public class BasePathExpsoer implements ServletContextAware {

	private ServletContext application;
	
	private String rootPath;
	
	private void init(){
		rootPath = application.getContextPath();
		application.setAttribute("rootPath", rootPath);
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

}
