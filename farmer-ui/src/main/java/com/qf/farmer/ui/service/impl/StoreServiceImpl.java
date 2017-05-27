package com.qf.farmer.ui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.ui.client.EsClient;
import com.qf.farmer.ui.client.StoreDbClient;
import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.service.StoreService;
import com.qf.farmer.ui.util.Page;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDbClient storeDbClient;
	@Autowired
	private EsClient esClient;
	
	@Override
	public Store saveStore(Store store) {
		return esClient.saveStore(store);
//		return storeDbClient.saveStore(store);
	}

	@Override
	public Page<Store> findStorePage(Store store) {
		return esClient.findStorePage(store);
	}

}
