package com.qf.farmer.ui.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.farmer.ui.domain.User;

@Controller
public class MallController {

	@RequestMapping("/")
    public String index(Principal user,HttpServletRequest request) {
		if(user!=null){
			User u=(User) request.getSession().getAttribute("user");
			if(u==null){
				u=new User();
				u.setUserName(user.getName());
				OAuth2Authentication ou=(OAuth2Authentication) user;
				System.out.println(ou.getOAuth2Request().getClientId());
				request.getSession().setAttribute("user", u);
			}
//			if(!u.getUserName().equals(user.getName())){
//				u.setUserName(user.getName());
//				request.getSession().setAttribute("user", u);
//			}
		}
        return "forward:/index/mall";
    }
}
