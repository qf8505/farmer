package com.qf.farmer.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qf.farmer.es.domain.Store;

public interface StoreRepository extends ElasticsearchRepository<Store, String>{
	
}
