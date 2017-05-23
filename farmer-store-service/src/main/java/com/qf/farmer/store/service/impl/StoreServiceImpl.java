package com.qf.farmer.store.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.common.exception.BusinessException;
import com.qf.farmer.store.domain.Store;
import com.qf.farmer.store.repository.StoreRepository;
import com.qf.farmer.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Override
	public Store saveStore(Store store) {
		List<Store> list=null;
		if(StringUtils.isNotBlank(store.getStoreName())){
			list=storeRepository.findByStoreName(store.getStoreName());
			if(list!=null&&list.size()!=0){
				throw new BusinessException("店铺已经存在");
			}
		}else{
			throw new BusinessException("没有找到该店铺");
		}
		return storeRepository.save(store);
	}
}
