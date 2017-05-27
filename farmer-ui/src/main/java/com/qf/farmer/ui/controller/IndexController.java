package com.qf.farmer.ui.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

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
	public String mall(Principal user,HttpServletRequest request){
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
	/**
	 * 打开购物车
	 * @return
	 */
	@RequestMapping(value = "shopcar", method = RequestMethod.GET)
	public String shopcar(){
		return "mall/shopcar";
	}
	/**
	 * 进入付款页面
	 * @return
	 */
	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public String pay(){
		return "mall/pay";
	}
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value = "loginOut", method = RequestMethod.GET)
	public String loginOut(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/index/mall";
	}
}
