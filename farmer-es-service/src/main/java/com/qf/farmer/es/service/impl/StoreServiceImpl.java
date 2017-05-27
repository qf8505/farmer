package com.qf.farmer.es.service.impl;

import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.qf.farmer.es.domain.Store;
import com.qf.farmer.es.repository.StoreRepository;
import com.qf.farmer.es.service.StoreService;
import com.qf.farmer.es.vo.StoreVo;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Page<Store> findStorePage(StoreVo storeVo) {
		QueryBuilder filters=QueryBuilders.wildcardQuery("storeName", "*"+(storeVo.getStoreName()==null?"":storeVo.getStoreName())+"*");
		QueryBuilder filters2=QueryBuilders.geoDistanceQuery("location").point(storeVo.getLat(), storeVo.getLon()).distance(1, DistanceUnit.KILOMETERS);
		QueryBuilder query=QueryBuilders.andQuery(filters2,filters);
		@SuppressWarnings("deprecation")
		SearchQuery sq = new NativeSearchQueryBuilder().withQuery(query).withSort(new FieldSortBuilder("id").ignoreUnmapped(true).order(SortOrder.DESC)).build();  
        return storeRepository.search(sq);
	}

	@Override
	public Store saveStore(StoreVo storeVo) {
		Store store=new Store();
		BeanUtils.copyProperties(storeVo,store);
		store.setLocation(new GeoPoint(storeVo.getLat(), storeVo.getLon()));
		return storeRepository.save(store);
	}

}
