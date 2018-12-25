package com.sam.test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.sam.entity.User;
import com.sam.util.HibernateUtil;

public class TestHibernate {
	
	private SessionFactory sessionFactory;
	
	@Test
	public void handle(){
		
		// 读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		User user = new User();
		user.setId(5);
		user.setUsername("future");
		user.setAccount("aaaaa");
		Transaction tx = session.beginTransaction();
		session.save(user);
		user.setAccount("sdfasd");
		tx.commit();
		session.close();
	}
	
	@Test
	public void handle2(){
		
		// 读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = (User) session.get(User.class, 1);
		System.out.println(user.getUsername());
		
		tx.commit();
		session.close();
	}
	
	
	@Test
	public void handle3(){
		
		// 读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = (User) session.load(User.class,2);
		System.out.println(user.getUsername());
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void handle4(){
		// 读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		List<User> users = session.createQuery("from User").list();
		for (User user : users) {
			System.out.println(user.getAccount());
		}
		tx.commit();
		session.close();
	}
	
	/**
	 * 可通过Session对象的
	 * get()
	 * load()
	 * save()
	 * update()
	 * delete()
	 * saveOrUpdate()
	 * createQuery()  等方法对进行CURD等操作；
	 * 
	 * load  与    get   的区别
	 * 1：get和load的主要区别在于是否延迟加载，load具有延迟加载的功能，load方法不会立即访问数据库，
	 * 2：当视图加载的记录在数据表中不存在的时候。load方法可能返回一个未初始化的代理对象，
	 * 而get总是立即访问数据库，当试图加载的记录不存在的时候，get()方法将直接返回null
	 */
	
	/* --------------------- HibernateUtil 测试 ------------------ */
	
	/**
     * 添加用户
     */
	@Test
    public void addUser() {
        //创建实体类(瞬态对象)
    	User user = new User();
        user.setAccount("1987445345");
        user.setPassword("111111");
        user.setUsername("Tom");
        //获得Session对象
        Session session = HibernateUtil.getsSession();
        //获得Transaction实例 
        Transaction tc = session.beginTransaction();
        try {
            // 使用Session的save方法将持久化对象保存到数据库  
            session.save(user);
            // 提交事务  
            tc.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            // 出现异常，回滚事务  
            tc.rollback(); 
        }finally {
            // 关闭Session连接 
            HibernateUtil.closeSession();
        }

    }

	/**
     * 查找用户
     */
	@Test
    public void getUser() {
        User user = null;
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();
        try {
            // 使用session的get方法获取指定id的用户 
        	user = (User) session.get(User.class, 2);
            System.out.println(user.getAccount());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            HibernateUtil.closeSession();
        }
    }
	
	 /**
     * 删除用户
     */
	@Test
    public void deleteUser() {
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();
        try {
            // 使用session加载一个持久化对象 
            User user = (User) session.get(User.class, 7);
            session.delete(user);
            System.out.println(user.getUsername()+":"+user.getAccount());
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            HibernateUtil.closeSession();
        }
    }

    /**
     * 更新用户资料
     */
	@Test
    public void updateUser() {
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        try {  
            // 使用session的update方法更新持久化对象 
            User user = (User) session.get(User.class, 6);
            user.setUsername("Alice");
            session.update(user);  
            tx.commit();  
        } catch (Exception e) {  
            tx.rollback();  
            e.printStackTrace();
        } finally {  
            HibernateUtil.closeSession();  
        }  
    }
	
	
	@Test
    public void myCreateQuery() {
        Session session = HibernateUtil.getsSession();  
        Transaction tx = session.beginTransaction();  
        
        List<User> users = session.createQuery("from User").list();
    	for (User user : users) {
    		System.out.println(user.getAccount());
    	}
    }
	
	
	
}

