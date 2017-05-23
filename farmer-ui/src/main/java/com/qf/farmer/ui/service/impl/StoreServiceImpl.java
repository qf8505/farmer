package com.qf.farmer.ui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.ui.client.StoreDbClient;
import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDbClient storeDbClient;
	
	@Override
	public Store saveStore(Store store) {
		return storeDbClient.saveStore(store);
	}

}
