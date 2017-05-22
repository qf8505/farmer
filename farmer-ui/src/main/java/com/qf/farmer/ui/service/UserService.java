package com.qf.farmer.ui.service;

import com.qf.farmer.ui.domain.User;

public interface UserService {

	User findUser(String userId);
	
	User register(User user);
}
