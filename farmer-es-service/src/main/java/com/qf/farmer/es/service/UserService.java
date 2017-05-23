package com.qf.farmer.es.service;

import com.qf.farmer.es.domain.User;
/**
 * 用户搜索
 * @author qinfei
 *
 */
public interface UserService {

	User findUser(String userId);
}
