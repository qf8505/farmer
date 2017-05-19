package com.qf.farmer.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qf.farmer.es.domain.User;

public interface UserRepository extends ElasticsearchRepository<User, String>{
	
}
