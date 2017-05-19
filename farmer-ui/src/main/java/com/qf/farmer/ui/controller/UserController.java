package com.qf.farmer.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "findUser", method = RequestMethod.GET)
	public User findUser(@RequestParam("userId") String userId){
		return userService.findUser(userId);
	}
}
