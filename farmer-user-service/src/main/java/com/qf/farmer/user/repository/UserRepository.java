package com.qf.farmer.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qf.farmer.user.domain.User;
/**
 * 用户jpa服务
 * @author qinfei
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEmail(String email);
	
	List<User> findByPhone(String phone);
	
	List<User> findByUserNameOrEmailOrPhone(String userName,String email,String phone);
	
	List<User> findByUserName(String userName);

	/**
	 * 根据来源用户名和来源获取对应系统用户
	 * @param userName
	 * @param clientId
	 * @return
	 */
	List<User> findBySUserNameAndSource(String userName, String clientId);
}
