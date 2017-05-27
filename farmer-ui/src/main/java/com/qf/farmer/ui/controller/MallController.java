package com.qf.farmer.ui.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;

@Controller
public class MallController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
    public String index(Principal user,HttpServletRequest request) {
        return "forward:/index/mall";
    }
}
