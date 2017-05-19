package com.qf.farmer.ui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.ui.client.UserEsClient;
import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEsClient userEsClient;
	
	@Override
	public User findUser(String userId) {
		return userEsClient.findUser(userId);
	}

}
