package com.qf.farmer.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.es.domain.Store;
import com.qf.farmer.es.service.StoreService;
import com.qf.farmer.es.vo.StoreVo;

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
    @RequestMapping(value = "findStorePage", method = RequestMethod.POST)
    public Page<Store> findStorePage(@RequestBody StoreVo storeVo){
        return storeService.findStorePage(storeVo);
    }
    
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<Store> list(StoreVo storeVo){
    	LOG.debug(storeVo.getStoreName());
        return storeService.findStorePage(storeVo);
    }
    
    /**
     * 新增店铺
     * @param store
     * @return
     */
    @RequestMapping(value = "saveStore", method = RequestMethod.POST)
    public Store saveStore(@RequestBody StoreVo storeVo){
        return storeService.saveStore(storeVo);
    }
}
