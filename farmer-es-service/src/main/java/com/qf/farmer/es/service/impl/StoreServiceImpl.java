package com.qf.farmer.es.service.impl;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.qf.farmer.es.domain.Store;
import com.qf.farmer.es.repository.StoreRepository;
import com.qf.farmer.es.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Page<Store> findStorePage(Store store) {
		QueryBuilder filters=QueryBuilders.wildcardQuery("storeName", "*"+store.getStoreName()+"*");
		@SuppressWarnings("deprecation")
		SearchQuery sq = new NativeSearchQueryBuilder().withQuery(filters).withSort(new FieldSortBuilder("id").ignoreUnmapped(true).order(SortOrder.DESC)).build();  
        return storeRepository.search(sq);
	}

	@Override
	public Store saveStore(Store store) {
		return storeRepository.save(store);
	}

}
