package com.sam.inter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.junit.Before;
import org.junit.Test;

import com.sam.bean.User;

public class TestTeacherMapper {
	
	//全局变量  SqlSession 不能定义全局
	private SqlSessionFactory sessionFactory;
	
	@Before
	public void before() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	/**
	 * mybatis 接口测试
	 * @throws Exception
	 */
	@Test
	public void interUser() throws Exception{
		SqlSession session = sessionFactory.openSession(true);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		List<User> users = teacherMapper.interUser("keke");
		System.out.println(JSONUtil.serialize(users));
		for (User user : users) {
			System.out.println(user.getAccount());
			System.out.println(user.getAddress());
			System.out.println(user.getUsername());
		}
	}
	

}
