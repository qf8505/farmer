package com.qf.farmer.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.qf.farmer.oauth.config.UserSecurityInterceptor;
/**
 * 授权登录
 * 
 * @author qinfei
 *
 */
@SpringBootApplication
@SessionAttributes("authorizationRequest")
@EnableResourceServer
@EnableDiscoveryClient
@EnableFeignClients
public class AuthServerApplication  extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/oauth/confirm_access").setViewName("authorize");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/**");
	}
}
