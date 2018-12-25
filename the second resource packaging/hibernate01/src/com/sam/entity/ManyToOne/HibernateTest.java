package com.sam.entity.ManyToOne;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest {

	@Test
	public void handle(){
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		MPerson person = new MPerson();
		person.setName("哎哎哎");
		person.setAge(23);
		
		MAddress address = new MAddress();
		address.setAddress("天津");
		person.setAddress(address);

		session.save(person);
		tx.commit();
		session.close();
	}
	
	@Test
	public void handle2(){
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from MPerson where address_id = 1";
		List<MPerson> persons =session.createQuery(hql).list();
		for (MPerson person : persons) {
			System.out.println(person.getName()+"----"+person.getAddress().getAddress());
		}
		
		tx.commit();
		session.close();
	}
	
	
}
