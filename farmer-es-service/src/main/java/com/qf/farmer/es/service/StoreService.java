package com.qf.farmer.es.service;

import org.springframework.data.domain.Page;

import com.qf.farmer.es.domain.Store;
import com.qf.farmer.es.vo.StoreVo;

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
	Page<Store> findStorePage(StoreVo storeVo);
	/**
	 * 新增店铺
	 * @param store
	 * @return
	 */
	Store saveStore(StoreVo storeVo);
}
