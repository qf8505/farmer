package com.qf.farmer.ui.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qf.farmer.common.util.CommonUtil;
import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;
import com.qf.farmer.ui.util.UserTypeEnum;

/**
 * 用户管理
 * @author qinfei
 *
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "findUser", method = RequestMethod.GET)
	@ResponseBody
	public User findUser(@RequestParam("userId") String userId){
		return userService.findUser(userId);
	}
	/**
	 * 用户登录
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(User user,HttpServletRequest request){
		ModelAndView model=null;
		try{
			user=userService.login(user);
			model=new ModelAndView("redirect:/index/mall");
			request.getSession().setAttribute("user", user);
			return model;  
		}catch(Exception e){
			model=new ModelAndView("mall/login");
			model.addObject("msg", CommonUtil.checkException(e));
			return model;  
		}
	}
	/**
	 * 个人中心
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userInfo", method = RequestMethod.GET)
	public ModelAndView userInfo(HttpServletRequest request){
		return new ModelAndView("mall/userInfo");
	}
}
