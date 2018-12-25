package com.sam.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.sam.entity.Person;

public class TestHibernate03 {

	@Test
	public void AddOrCreatePerson(){
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Person person = new Person();
		
		person.setName("xiaoyuer");
		person.setAge(23);
		
		List<String> lists = new ArrayList<String>();
		lists.add("北京大学");
		lists.add("长沙大学");
		lists.add("天南大学");
		person.setSchools(lists);
		
		String[] classmates = {"青春","年华","无悔"};
		person.setClassmates(classmates);
		
		Set<String> firends = new HashSet<String>();
		firends.add("keke");
		firends.add("jame");
		firends.add("kery");
		person.setFirends(firends);
		
		Map<String, Float> scores = new HashMap<String, Float>();
		scores.put("语文", 115.5f);
		scores.put("数学", 90.5f);
		scores.put("语言", 100f);
		person.setScore(scores);
		
		session.save(person);
		tx.commit();
		session.close();
	}
	
	
}
