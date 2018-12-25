package com.sam.service.ipml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.bean.User;
import com.sam.dao.IUserMapper;
import com.sam.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public User getLogin(User user) {
		return userMapper.getLogin(user);
	}
	
	
	
}
