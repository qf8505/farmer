package com.qf.farmer.ui.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qf.farmer.common.util.CommonUtil;
import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;
import com.qf.farmer.ui.util.UserTypeEnum;

@Controller
@RequestMapping(path = "/index")
public class IndexController {

	@Autowired
	private UserService userService;
	
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
	 * 用户注册
	 * @param user
	 * @param passWordRepeat
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView register(User user,String passWordRepeat){
		ModelAndView model=null;
		if(user.getPassWord().equals(passWordRepeat)){
			try{
				user.setUserType(UserTypeEnum.USER.getValue());
				userService.register(user);
			}catch(Exception e){
				model=new ModelAndView("mall/register");
				model.addObject("msg", CommonUtil.checkException(e));
				return model;  
			}
		}else{
			model=new ModelAndView("mall/register");
			model.addObject("msg", "两次输入的密码不一致");
			return model;  
		}
		return new ModelAndView("mall/regSuccess");
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
