package com.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
import com.sam.bean.User;

/**
 * mybatis测试去数据库里的值
 * @author Administrator
 *
 */
public class TestMybatis {
	
	//全局变量  SqlSession 不能定义全局
	private SqlSessionFactory sessionFactory;
	
	@Before
	public void before() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void hander() throws IOException{
		SqlSession sqlSession = sessionFactory.openSession();
		List<User> users = sqlSession.selectList("com.sam.bean.userMapper.findUsers");
		for (User user : users) {
			System.out.println("================"+user.getUsername());
			System.out.println("================"+user.getCreateTime());
			System.out.println("================"+user.getUpdateTime());
			System.out.println("================"+user.getTeacherId());
			System.out.println("================"+user.getSubjectId());
			System.out.println("-------------------------------------");
		}
	}
	
	@Test
	public void getUser() throws IOException, JSONException{
		SqlSession sqlSession = sessionFactory.openSession();
		User user = sqlSession.selectOne("com.sam.bean.userMapper.getUser", 12);
		System.out.println(JSONUtil.serialize(user));
	}
	
	//查询总数
	@Test
	public void countUser() {
		SqlSession sqlSession = sessionFactory.openSession();
		int count = sqlSession.selectOne("com.sam.bean.userMapper.countUser");
		System.out.println(count);
	}
	
	//分页查询
	@Test
	public void limitUser() throws JSONException{
		SqlSession sqlSession = sessionFactory.openSession();
		Parmes parmes = new Parmes();
		parmes.setPageNo(0);
		parmes.setPageSize(2);
		List<User> users = sqlSession.selectList("com.sam.bean.userMapper.limitUser",parmes);
		System.out.println(JSONUtil.serialize(users));
		
	}
	
	@Test
	public void likeUser() throws JSONException {
		SqlSession sqlSession = sessionFactory.openSession();
		Parmes parmes = new Parmes();
		parmes.setUsername("keke");
		parmes.setPassword("xiaoer");
		parmes.setOrder("create_time desc");
		List<User> users = sqlSession.selectList("com.sam.bean.userMapper.likeUser", parmes);
		System.out.println(JSONUtil.serialize(users));
	}
	
	@Test
	public void saveUser() throws IOException{
		//openSession(true) 代表自动事务提交
		SqlSession sqlSession = sessionFactory.openSession(true);
		User user = new User();
		user.setUsername("keke3");
		user.setPassword("xiaoer");
		user.setAccount("xiaoyuer");
		user.setTelephone("157878787");
		user.setIdcard("1425303197897879");
		user.setMale(0);
		user.setBirthday(new Date());
		user.setEmail("787864880@qq.com");
		user.setAddress("湖南长沙");
		user.setAge(23);
		user.setIsDelete(1);
		user.setTeacherId(001);
		user.setSubjectId(1208);
		user.setStatus(1);
		user.setType(1);
		int count = sqlSession.insert("com.sam.bean.userMapper.saveUser",user);
		System.out.println(count > 0 ? "保存成功" : "保存失败");
		sqlSession.close();
	}
	
	@Test
	public void updateUser(){
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setUsername("gege");
		user.setId(11);
		int count = sqlSession.update("com.sam.bean.userMapper.updateUser", user);
		System.out.println(count>0 ? "更新成功" : "更新失败");
	}
	
	@Test
	public void deleteUser(){
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		int count = sqlSession.delete("com.sam.bean.userMapper.deleteUser", 2);
		System.out.println(count>0 ? "删除成功" : "删除失败");
	}
	
	
}
