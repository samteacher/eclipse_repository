package com.sam.inter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import com.sam.bean.Parmes;
import com.sam.bean.Student;
import com.sam.bean.User;

public class TestStudentMapper {
	
	//全局变量  SqlSession 不能定义全局
	private SqlSessionFactory sessionFactory;
	
	@Before
	public void before() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findStudents() throws Exception{
		SqlSession session = sessionFactory.openSession();
		Student student = new Student();
		student.setId(1);
		student.setTeacher_id(1);
		List<User> users = session.selectList("com.sam.dao.user.IUserMapper.findStudents", student);
		System.out.println(JSONUtil.serialize(users));
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getId());
		}
	}
	
	@Test
	public void findInStudent() throws Exception{
		SqlSession session = sessionFactory.openSession();
		Parmes parmes = new Parmes();
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(11);
	    list.add(12);
	    list.add(13);
	    parmes.setOptis(list);
		List<User> users = session.selectList("com.sam.inter.StudentMapper.findInStudent", parmes);
		System.out.println(JSONUtil.serialize(users));
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getId());
		}
	}
	

}
