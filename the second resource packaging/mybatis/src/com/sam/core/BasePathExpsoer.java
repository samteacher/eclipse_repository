package com.sam.core;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import com.sam.util.MyStringUtils;

/**
 * 统一路径
 * 
 * @author Administrator
 * 
 */
public class BasePathExpsoer implements ServletContextAware {

	private ServletContext application;

	private String rootPath;

	public void init() {
		if (MyStringUtils.isEmpty(rootPath)) {
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);
		application.setAttribute("resPath", rootPath+"/resource");
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

}
