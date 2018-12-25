package com.sam.aop.dao;

public class UserDaoImpl implements UserDao {

	@Override
	public void saveUser(User user) {
		//transaction.beginTransaction()
		System.out.println("开始事务提交");
		System.out.println("保存用户"+user);
		System.out.println("提交成功");
	}

	@Override
	public void deleteUser(Integer id) {
		//transaction.beginTransaction()
		System.out.println("开始事务提交");
		System.out.println("删除用户"+id);
		System.out.println("提交成功");
	}

	@Override
	public void updateUser(Integer id, User user) {
		//transaction.beginTransaction()
		System.out.println("开始事务提交");
		System.out.println("更新用户"+id);
		System.out.println("提交成功");
	}



}
