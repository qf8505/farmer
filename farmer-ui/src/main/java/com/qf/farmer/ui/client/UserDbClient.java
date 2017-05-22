package com.qf.farmer.ui.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.farmer.ui.domain.User;

/**
 * 访问数据库服务客户端
 * 
 * @author qinfei
 *
 */
@FeignClient(name = "farmer-user-service")
public interface UserDbClient {

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public User register(@RequestBody User user);
}