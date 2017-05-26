package com.qf.farmer.oauth.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.farmer.oauth.domain.User;
import com.qf.farmer.oauth.util.BusinessErrorDecoder;

/**
 * 访问数据库服务客户端
 * 
 * @author qinfei
 *
 */
@FeignClient(name = "farmer-user-service",configuration=BusinessErrorDecoder.class)
public interface UserDbClient {

	/**
	 * 获取用户信息
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/findUserByUserName", method = RequestMethod.POST)
	@ResponseBody
	public User findUserByUserName(@RequestBody String userName);
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public User login(@RequestBody User user);
}