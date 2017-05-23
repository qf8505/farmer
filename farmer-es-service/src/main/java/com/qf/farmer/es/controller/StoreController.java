package com.qf.farmer.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.es.domain.Store;
import com.qf.farmer.es.service.StoreService;

@RestController
public class StoreController{
    @Autowired
    private StoreService storeService;

    private static final Logger LOG = LoggerFactory.getLogger(StoreController.class);

    /**
     * 查询店铺分页列表
     * @param store
     * @return
     */
    @RequestMapping(value = "findStorePage", method = RequestMethod.GET)
    public Page<Store> findStorePage(Store store){
    	LOG.debug(store.getStoreName());
        return storeService.findStorePage(store);
    }
    
    /**
     * 新增店铺
     * @param store
     * @return
     */
    @RequestMapping(value = "saveStore", method = RequestMethod.POST)
    public Page<Store> saveStore(Store store){
        return storeService.findStorePage(store);
    }
}
