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
		if(user!=null){
			try{
				User u=(User) request.getSession().getAttribute("user");
				if(u==null){
					String clientId=null;
					if(user instanceof OAuth2Authentication){
						OAuth2Authentication ou=(OAuth2Authentication) user;
						clientId=ou.getOAuth2Request().getClientId();
					}
					u=userService.findUserBySUserName(user.getName(),clientId);
					if(u==null){
						u=new User();
						u.setUserName(user.getName());
					}
					request.getSession().setAttribute("user", u);
				}
//				if(!u.getUserName().equals(user.getName())){
//					u.setUserName(user.getName());
//					request.getSession().setAttribute("user", u);
//				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
        return "forward:/index/mall";
    }
}
