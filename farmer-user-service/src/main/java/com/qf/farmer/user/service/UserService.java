package com.qf.farmer.user.service;

import com.qf.farmer.user.domain.User;

public interface UserService{

	User saveUser(User user);
	
	User findUser(long id);
	
	User login(String userName,String passWord);

	User findUserByUserName(String userName);
}
