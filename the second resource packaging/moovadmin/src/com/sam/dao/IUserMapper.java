package com.sam.dao;

import org.springframework.stereotype.Repository;

import com.sam.bean.User;

@Repository
public interface IUserMapper {

	public User getLogin(User user);
}
