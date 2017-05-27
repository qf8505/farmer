package com.qf.farmer.ui.service;

import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.util.Page;

/**
 * 店铺操作
 * @author qinfei
 *
 */
public interface StoreService {

	/**
	 * 店铺保存
	 * @param store
	 * @return
	 */
	Store saveStore(Store store);
	/**
	 * 店铺查找
	 * @param store
	 * @return
	 */
	public Page<Store> findStorePage(Store store);
}
