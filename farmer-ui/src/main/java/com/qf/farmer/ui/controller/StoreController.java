package com.qf.farmer.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.service.StoreService;

/**
 * 店铺管理
 * @author qinfei
 *
 */
@Controller
@RequestMapping(path = "/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	/**
	 * 打开店铺新增页
	 * @return
	 */
	@RequestMapping(value = "addStore", method = RequestMethod.GET)
	public ModelAndView addStore(){
		return new ModelAndView("/mall/store");
	}
	
	/**
	 * 新增店铺
	 * @return
	 */
	@RequestMapping(value = "saveStore", method = RequestMethod.POST)
	public ModelAndView saveStore(Store store){
		ModelAndView model=new ModelAndView("/mall/store");
		Store s=storeService.saveStore(store);
		model.addObject("store", s);
		return model;
	}
}
