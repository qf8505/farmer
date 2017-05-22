package com.qf.farmer.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * 用户注册
	 * @param user
	 * @param passWordRepeat
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(User user,String passWordRepeat){
		if(user.getPassWord().equals(passWordRepeat)){
			try{
				user.setUserType(UserTypeEnum.USER.getValue());
				userService.register(user);
			}catch(Exception e){
				return "redirect:/index/register";  
			}
		}else{
			return "redirect:/index/register";  
		}
		return "mall/regSuccess";
	}
}
