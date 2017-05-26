package com.qf.farmer.oauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.qf.farmer.oauth.client.UserDbClient;
import com.qf.farmer.oauth.domain.SecurityUser;
import com.qf.farmer.oauth.domain.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDbClient userDbClient;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //User对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:

    	User user=userDbClient.findUserByUserName(userName);
    	
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        if (user == null) {
            throw new UsernameNotFoundException("用户: " + userName + "不存在");
        }
        SecurityUser securityUser = new SecurityUser();
        securityUser.setEmail(user.getEmail());
        securityUser.setUsername(user.getUserName());
        securityUser.setPassword(user.getPassWord());
        return securityUser; //code9

    }

}
