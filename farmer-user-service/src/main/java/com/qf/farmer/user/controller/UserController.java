package com.qf.farmer.user.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.user.domain.User;
import com.qf.farmer.user.service.UserService;

/**
 * 作用： ① 测试服务实例的相关内容 ② 为后来的服务做提供
 * 
 * @author qf
 */
@RestController
public class UserController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private UserService userService;

	/**
	 * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
	 * @RequestMapping(value = "/id", method = RequestMethod.GET)类似的注解还有@PostMapping等等
	 * @param id
	 * @return user信息
	 */
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.userService.findUser(id);
		return findOne;
	}

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.saveUser(user);
	}
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user.getsUserName(),user.getPassWord());
	}

	@PostMapping("/findUserByUserName")
	public User findUserByUserName(@RequestBody String userName) {
		return userService.findUserByUserName(userName);
	}
	
	@PostMapping("/findUserBySUserName")
	public User findUserBySUserName(@RequestBody Map<String,String> map){
		return userService.findUserBySUserName(map.get("userName"),map.get("clientId"));
	}
	
	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
