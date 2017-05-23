package com.qf.farmer.store.controller;

import java.util.List;

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

import com.qf.farmer.store.domain.Store;
import com.qf.farmer.store.service.StoreService;

/**
 * 作用： ① 测试服务实例的相关内容 ② 为后来的服务做提供
 * 
 * @author qf
 */
@RestController
public class StoreController {
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private StoreService storeService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/saveStore")
	public Store saveStore(@RequestBody Store store) {
		return storeService.saveStore(store);
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
