package com.wh.demo.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.demo.test.dao.UserDao;
import com.wh.demo.test.model.UserEntity;
import com.wh.demo.test.service.UserService;

@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity getUserById(int id) {
		return userDao.getUserById(id);
	}}
