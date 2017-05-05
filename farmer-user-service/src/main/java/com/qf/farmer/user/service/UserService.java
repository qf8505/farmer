package com.qf.farmer.user.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qf.farmer.user.domain.User;

@Repository
public interface UserService extends JpaRepository<User, Long>{

}
