package com.qf.farmer.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qf.farmer.ui.client.UserEsClient.HystrixClientFallback;
import com.qf.farmer.ui.domain.User;

//@FeignClient(name = "farmer-es-service",fallback = HystrixClientFallback.class)
@FeignClient(name = "farmer-es-service")
public interface UserEsClient {
	
  @RequestMapping(value="/findUser",method=RequestMethod.GET)
  public User findUser(@RequestParam("userId") String userId);
  
  /**
   * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
   * @author qf
   */
  @Component
  static class HystrixClientFallback implements UserEsClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);

	@Override
	public User findUser(String userId) {
		HystrixClientFallback.LOGGER.info("异常发生，进入fallback方法，接收的参数： {},{}",userId);
		return null;
	}
  }
}