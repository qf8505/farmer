package com.qf.farmer.neo.service;

import com.qf.farmer.neo.domain.User;

public interface UserService {

	void initData();
	
	User getUserByName(String name);

}
