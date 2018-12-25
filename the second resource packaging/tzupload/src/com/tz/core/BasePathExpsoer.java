/**
 * tzdesk系统平台
 * tzupload
 * com.tz.core
 * BasePathExpsoer.java
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午10:27:57 
 * 2015潭州教育公司-版权所有
 */
package com.tz.core;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import com.tz.util.TmStringUtils;

/**
 * 
 * BasePathExpsoer
 * 创建人:xuchengfei 
 * 时间：2015年11月13日-下午10:27:57 
 * @version 1.0.0
 * 
 */
public class BasePathExpsoer  implements ServletContextAware{

	private ServletContext application;
	private ApplicationContext context;

	private String rootPath;
	public void init(){
		if(TmStringUtils.isEmpty(rootPath)){
			rootPath = application.getContextPath();
		}
		application.setAttribute("rootPath", rootPath);
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
}
