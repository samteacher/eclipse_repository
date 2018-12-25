package com.moov.web;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ServletContextAware;

import com.moov.util.StringUtil;

/**
 * 绝对路径解决方案二
 * 
 * @author Administrator
 * 
 */
public class BasePathExpsoer implements ServletContextAware {

	private ServletContext application;
	private ApplicationContext context;

	private String rootPath;

	public void init() {
		if (StringUtil.isEmpty(rootPath)) {
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);
		application.setAttribute("resPath", rootPath+"/resources");
	}

	// 全路径
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

}
