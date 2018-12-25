package com.sam.entity.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

/**
 * 一对多用的场景不多 
 * @author Administrator
 *
 */
public class HibernateOneToManyTest {

	@Test
	public void OneToManyTest(){
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		CityOneToMany city = new CityOneToMany();
		city.setName("上海");
		
		List<PersonOneToMany> personOneToManies = new ArrayList<PersonOneToMany>(); 
		
		PersonOneToMany person = new PersonOneToMany();
		person.setName("keke");
		person.setCity(city);
		personOneToManies.add(person);
		person = new PersonOneToMany();
		person.setName("jame");
		person.setCity(city);
		personOneToManies.add(person);
		
		city.setPerons(personOneToManies);
		
		session.save(city);
		tx.commit();
		session.close();
	}
	
	
}
