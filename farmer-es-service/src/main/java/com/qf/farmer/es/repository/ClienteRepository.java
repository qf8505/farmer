package com.qf.farmer.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.qf.farmer.es.domain.Cliente;

public interface ClienteRepository extends ElasticsearchRepository<Cliente, String>{
	
}
