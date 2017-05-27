package com.qf.farmer.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/goods")
public class GoodsController {

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String mall(String id,HttpServletRequest request){
		return "mall/goodsDetail";
	}
}
