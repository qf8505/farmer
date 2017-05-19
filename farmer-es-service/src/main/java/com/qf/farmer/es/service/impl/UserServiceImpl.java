package com.qf.farmer.es.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.es.domain.User;
import com.qf.farmer.es.repository.UserRepository;
import com.qf.farmer.es.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(String userId) {
		return userRepository.findOne(userId);
	}

}
