package com.qf.farmer.redis.service;

import com.qf.farmer.redis.domain.Address;
import com.qf.farmer.redis.domain.User;

public interface DemoService {

	User findUser(Long id, String firstName, String lastName);

	Address findAddress(Long id, String province, String city);

}
