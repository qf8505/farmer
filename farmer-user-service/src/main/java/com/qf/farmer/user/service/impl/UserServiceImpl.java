package com.qf.farmer.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.farmer.common.exception.BusinessException;
import com.qf.farmer.user.domain.User;
import com.qf.farmer.user.repository.UserRepository;
import com.qf.farmer.user.service.UserService;
import com.qf.farmer.user.util.PasswordEncoderUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		List<User> list=null;
		if(StringUtils.isNotBlank(user.getEmail())){
			list=userRepository.findByEmail(user.getEmail());
			if(list!=null&&list.size()!=0){
				throw new BusinessException("邮箱已经存在");
			}
			user.setUserName(user.getEmail());
		}else if(StringUtils.isNotBlank(user.getPhone())){
			list=userRepository.findByPhone(user.getPhone());
			if(list!=null&&list.size()!=0){
				throw new BusinessException("手机号已经存在");
			}
			user.setUserName(user.getPhone());
		}else{
			throw new BusinessException("没有找到注册账号");
		}
		user.setPassWord(PasswordEncoderUtil.encode(user.getPassWord()));
		return userRepository.save(user);
	}

	@Override
	public User findUser(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User login(String userName, String passWord) {
		List<User> list=userRepository.findByUserNameOrEmailOrPhone(userName, userName, userName);
		if(list!=null&&list.size()!=0){
			for(User user:list){
				if(StringUtils.isNotBlank(user.getPassWord())&&user.getPassWord().equals(passWord)){
					return user;
				}
			}
		}
		throw new BusinessException("用户名或密码错误!");
	}

}
