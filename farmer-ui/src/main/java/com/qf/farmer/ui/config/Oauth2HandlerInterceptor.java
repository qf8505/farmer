package com.qf.farmer.ui.config;

import java.lang.reflect.Method;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qf.farmer.ui.domain.User;
import com.qf.farmer.ui.service.UserService;

public class Oauth2HandlerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
        	try{
            	Principal user=request.getUserPrincipal();
            	if(user!=null){
            		User u=(User) request.getSession().getAttribute("user");
            		if(u!=null&&!u.getUserName().equals(user.getName())){
            			u=null;
            			request.getSession().removeAttribute("user");
            		}
    				if(u==null){
    					String clientId=null;
    					if(user instanceof OAuth2Authentication){
    						OAuth2Authentication ou=(OAuth2Authentication) user;
    						clientId=ou.getOAuth2Request().getClientId();
    					}
    					BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
    					UserService userService= (UserService) factory.getBean("userService");
    					u=userService.findUserBySUserName(user.getName(),clientId);
    					if(u==null){
    						u=new User();
    						u.setUserName(user.getName());
    					}
    					request.getSession().setAttribute("user", u);
    				}
            	}
			}catch(Exception e){
				e.printStackTrace();
			}
        return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
	}

}