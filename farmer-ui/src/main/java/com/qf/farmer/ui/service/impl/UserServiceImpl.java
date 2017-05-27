package com.qf.farmer.ui.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.ui.client.UserDbClient;
import com.qf.farmer.ui.client.UserEsClient;
import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEsClient userEsClient;
	@Autowired
	private UserDbClient userDbClient;
	
	@Override
	public User findUser(String userId) {
		return userEsClient.findUser(userId);
	}

	@Override
	public User register(User user) {
		return userDbClient.register(user);
	}

	@Override
	public User login(User user) {
		return userDbClient.login(user);
	}

	@Override
	public User findUserBySUserName(String userName, String clientId) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("userName", userName);
		map.put("clientId", clientId);
		return userDbClient.findUserBySUserName(map);
	}

}
