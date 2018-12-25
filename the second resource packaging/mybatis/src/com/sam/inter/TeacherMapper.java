package com.sam.inter;

import java.util.List;

import com.sam.bean.User;

public interface TeacherMapper {
	
	/**
	 * 查询用户
	 * @param username
	 * @return
	 */
	public List<User> interUser(String username);
	//public List<User> findUsers(@Param("username")String username);
	
	
}
