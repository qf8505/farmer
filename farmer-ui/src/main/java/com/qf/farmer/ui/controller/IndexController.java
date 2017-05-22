package com.qf.farmer.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/index")
public class IndexController {

	/**
	 * 打开商城首页
	 * @return
	 */
	@RequestMapping(value = "mall", method = RequestMethod.GET)
	public String findUser(){
		return "mall/mall";
	}
	/**
	 * 打开登录页
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(){
		return "mall/login";
	}
	/**
	 * 注册
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(){
		return "mall/register";
	}
}
