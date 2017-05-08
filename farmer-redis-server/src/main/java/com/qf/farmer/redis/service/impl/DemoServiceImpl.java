package com.qf.farmer.redis.service.impl;  
  
import com.qf.farmer.redis.domain.Address;
import com.qf.farmer.redis.domain.User;
import com.qf.farmer.redis.service.DemoService;
import org.springframework.cache.annotation.Cacheable;  
import org.springframework.stereotype.Service;  
  
/** 
 * Created by wisely on 2015/5/25. 
 */  
@Service  
public class DemoServiceImpl implements DemoService {  
	
	@Override
    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")  
    public User findUser(Long id,String firstName,String lastName){  
        System.out.println("无缓存的时候调用这里");  
        return new User(id,firstName,lastName);  
    } 
	
	@Override
    @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")  
    public Address findAddress(Long id,String province,String city){  
        System.out.println("无缓存的时候调用这里");  
        return new Address(id,province,city);  
    }  
} 