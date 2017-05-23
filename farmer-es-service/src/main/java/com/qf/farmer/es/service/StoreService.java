package com.qf.farmer.es.service;

import org.springframework.data.domain.Page;

import com.qf.farmer.es.domain.Store;

/**
 * 店铺搜索
 * @author qinfei
 *
 */
public interface StoreService {

	/**
	 * 查询店铺分页列表
	 * @param store
	 * @return
	 */
	Page<Store> findStorePage(Store store);
	/**
	 * 新增店铺
	 * @param store
	 * @return
	 */
	Store saveStore(Store store);
}
