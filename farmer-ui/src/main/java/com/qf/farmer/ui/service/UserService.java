package com.qf.farmer.ui.service;

import com.qf.farmer.ui.domain.User;
/**
 * 用户服务
 * @author qinfei
 *
 */
public interface UserService {

	/**
	 * 查找用户
	 * @param userId
	 * @return
	 */
	User findUser(String userId);
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	User register(User user);
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	User login(User user);
	/**
	 * 根据第三方登录账号获取该账号在系统内的用户
	 * @param name
	 * @param clientId
	 * @return
	 */
	User findUserBySUserName(String userName, String clientId);
}
