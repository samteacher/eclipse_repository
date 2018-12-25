package test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.tz.entity.Student;


public class TestHibernate {

	
	@Test
	public void handle(){
		//读取hibernate配置文件信息
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		//创建会话工厂
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//获取会话
		Session session = sessionFactory.openSession();
		//操作数据库了,CURD查询 sql hql qbc qbe
		List<Student> students = session.createSQLQuery("select * from student ").addEntity(Student.class).list();
		for (Student student : students) {
			System.out.println(student.getName());
			System.out.println(student.getAge());
			System.out.println("===================");
		}
	}
}
