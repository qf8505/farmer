package com.qf.farmer.ui.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.util.BusinessErrorDecoder;
import com.qf.farmer.ui.util.Page;

@FeignClient(name = "farmer-es-service",configuration=BusinessErrorDecoder.class)
public interface EsClient {

	@RequestMapping(value = "/saveStore", method = RequestMethod.POST)
	@ResponseBody
	public Store saveStore(@RequestBody Store store);
	
	@RequestMapping(value = "/findStorePage", method = RequestMethod.POST)
	@ResponseBody
	public Page<Store> findStorePage(@RequestBody Store store);
}