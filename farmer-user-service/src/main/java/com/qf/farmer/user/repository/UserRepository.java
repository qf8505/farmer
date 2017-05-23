package com.qf.farmer.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qf.farmer.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEmail(String email);
	
	List<User> findByPhone(String phone);
	
	List<User> findByUserNameOrEmailOrPhone(String userName,String email,String phone);
}
