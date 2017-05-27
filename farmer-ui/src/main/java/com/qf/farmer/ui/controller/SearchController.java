package com.qf.farmer.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qf.farmer.ui.domain.Store;
import com.qf.farmer.ui.service.StoreService;
import com.qf.farmer.ui.util.Page;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

	@Autowired
	private StoreService storeService;
	
	/**
	 * 商品搜索
	 * @param kw
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "goods")
	public ModelAndView goods(String kw,HttpServletRequest request){
		ModelAndView model=new ModelAndView("mall/goodsSearch");
		return model;
	}
	/**
	 * 店铺搜索
	 * @param kw
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "store")
	public ModelAndView store(Store store,HttpServletRequest request){
		Page<Store> page=storeService.findStorePage(store);
		ModelAndView model=new ModelAndView("mall/storeSearch");
		model.addObject("page", page);
		return model;
	}
}
