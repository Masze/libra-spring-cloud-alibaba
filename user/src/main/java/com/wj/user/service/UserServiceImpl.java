package com.wj.user.service;

import com.wj.api.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
	public User getUserById(String id) {

		User user = new User();
		user.setId(id);
		user.setName("name");
		return user;
	}
}
