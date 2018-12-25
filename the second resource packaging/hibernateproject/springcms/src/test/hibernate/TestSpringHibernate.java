package test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tz.entity.Student;
import com.tz.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/applicationContext.xml")
public class TestSpringHibernate {

//	@Autowired
//	private MySessionFactoryBean sessionFactoryBean;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
//	@Test
//	public void handle(){
//		SessionFactory sessionFactory2 = sessionFactoryBean.getSessionFactory();
//		//获取会话
//		Session session = sessionFactory2.openSession();
//		//操作数据库了,CURD查询 sql hql qbc qbe
//		List<Student> students = session.createSQLQuery("select * from student ").addEntity(Student.class).list();
//		for (Student student : students) {
//			System.out.println(student.getName());
//			System.out.println(student.getAge());
//			System.out.println("===================");
//		}
//	}
	
	
	@Test
	public void handle2(){
		Session session = sessionFactory.openSession();
		//操作数据库了,CURD查询 sql hql qbc qbe
		List<Student> students = session.createSQLQuery("select * from student ").addEntity(Student.class).list();
		for (Student student : students) {
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println("===================");
		}
	}
	
	
	@Test
	public void handle3(){	
		Session session = sessionFactory.openSession();
		//操作数据库了,CURD查询 sql hql qbc qbe
		List<User> users = session.createQuery("from User").list();
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("===================");
		}
	}
}
