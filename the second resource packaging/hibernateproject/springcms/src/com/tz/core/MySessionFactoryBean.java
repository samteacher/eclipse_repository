package com.tz.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactoryBean {

	//hibernate配置文件
	private String config;
	
	private SessionFactory sessionFactory;
	
	public void init(){
		Configuration configuration = new Configuration().configure(config);
		sessionFactory = configuration.buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setConfig(String config) {
		this.config = config;
	}
}
