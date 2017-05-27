package com.qf.farmer.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/search")
public class SearchController {

	@RequestMapping(value = "goods")
	public String mall(String kw,HttpServletRequest request){
		return "mall/goodsSearch";
	}
}
