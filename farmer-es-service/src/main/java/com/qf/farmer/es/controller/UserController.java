package com.qf.farmer.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.es.domain.User;
import com.qf.farmer.es.service.UserService;

@RestController
@RequestMapping(value = "/es/")
public class UserController{
    @Autowired
    private UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "findUser", method = RequestMethod.GET)
    public User findUser(String userId){
    	LOG.debug(userId);
        return userService.findUser(userId);
    }
}
