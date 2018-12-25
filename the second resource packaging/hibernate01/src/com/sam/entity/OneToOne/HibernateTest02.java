package com.sam.entity.OneToOne;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest02 {

	@Test
	public void handle1111(){
		
		// 读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		TyUser users = new TyUser();
		users.setName("keke");
		users.setPassword("123123");
		
		UserChildren userChildren = new UserChildren();
		userChildren.setAddress("山西");
		userChildren.setAge(22);
		userChildren.setBirthday(new Date());
		userChildren.setHobbys("跑步，看书");
		userChildren.setIdCard("123124235346367");
		userChildren.setIntroduce("奔无有佣兵仍的");
		userChildren.setMale("男");
		
		//双向，你中有我，我中有你
		userChildren.setUser(users);
		
		users.setUserChildren(userChildren);
		session.save(users);
		tx.commit();
		session.close();
	}
	
	
}
