package com.qf.farmer.store.service.impl;

import java.util.List;

import javax.persistence.LockModeType;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.qf.farmer.common.exception.BusinessException;
import com.qf.farmer.store.domain.Store;
import com.qf.farmer.store.repository.StoreRepository;
import com.qf.farmer.store.service.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
	
	/**
	 * 对店铺表使用读锁，@Lock(LockModeType.PESSIMISTIC_WRITE)  方式是写锁，写锁会导致其他事务无法进行并行锁操作
	 * select ... FOR UPDATE同时只能有一个在语句执行，另一个会阻塞；select ... LOCK IN SHARE MODE可以多个同时执行
	 * 特例：for udpate对使用唯一索引和主键这类保证唯一数据加锁(此类为行级锁，其他为表级锁)，不会对其他事物加锁有影响
	 * @param storeName
	 * @Query("select u from Store u where u.storeName= ?")  
	 * @return
	 */
	@Override
	@Lock(LockModeType.PESSIMISTIC_READ)
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
		kafkaTemplate.send("farmer",JSONObject.toJSONString(store));
		store=storeRepository.save(store);
		return store;
	}
}
