package com.qf.farmer.user.service;

import com.qf.farmer.user.domain.User;
/**
 * 用户服务
 * @author qinfei
 *
 */
public interface UserService{

	User saveUser(User user);
	
	User findUser(long id);
	
	User login(String userName,String passWord);

	User findUserByUserName(String userName);
	/**
	 * 根据第三方登录账号查找系统账号，如果clientId和本系统一直，则直接验证用户名，否则需要根据来源用户名获取对应的账号
	 * @param map
	 * @return
	 */
	User findUserBySUserName(String userName,String clientId);
}
