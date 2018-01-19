package com.wh.demo.test.service;

import com.wh.demo.test.model.UserEntity;

public interface UserService {
	/**
	 * 通过id得到user
	 * @param id
	 * @return
	 */
	public UserEntity getUserById(int id);
}
