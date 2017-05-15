package com.qf.farmer.es.service.impl;

import java.util.Iterator;

import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.qf.farmer.es.domain.Cliente;
import com.qf.farmer.es.repository.ClienteRepository;
import com.qf.farmer.es.service.EslService;

@Service
public class EslServiceImpl implements EslService{
    @Autowired
    private ClienteRepository clienteDao;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(EslServiceImpl.class);

    @Override
    public Cliente findCliente(String id){
    	BoolQueryBuilder bqb = new BoolQueryBuilder();
    	Cliente cliente=new Cliente();
    	cliente.setId("11");
    	cliente.setFirstname("qf11");
    	cliente.setLastname("df11");
    	GeoPoint location=new GeoPoint(50.005,49.995);
    	cliente.setLocation(location);
    	clienteDao.save(cliente);
        cliente = clienteDao.findOne(id);
        QueryBuilder filters1=QueryBuilders.matchQuery("firstname", "qf");
        QueryBuilder filters=QueryBuilders.wildcardQuery("lastname", "*dn*");
        QueryBuilder query=QueryBuilders.andQuery(filters1,filters);
        Iterable<Cliente> it=clienteDao.search(query);
        Iterator<Cliente> iter=it.iterator();
        while(iter.hasNext()){
        	System.out.println(iter.next());
        }
        
        
        QueryBuilder filters2=QueryBuilders.geoDistanceQuery("location").point(50, 50).distance(1, DistanceUnit.KILOMETERS);
        bqb.must(filters);
        bqb.must(filters2);
        
        PageImpl<Cliente> it2=(PageImpl<Cliente>) clienteDao.search(bqb);
        System.out.println(it2.getSize());
        Page<Cliente> p=clienteDao.findAll(new PageRequest(0, 20));
        System.out.println(p);
        
        SearchQuery sq=new NativeSearchQuery(filters2);
        Sort sort=new Sort(Direction.DESC,"id");
        sq.addSort(sort);
        Page<Cliente> pp=clienteDao.search(sq);
        iter=pp.iterator();
        while(iter.hasNext()){
        	System.out.println(iter.next());
        }
        
        sq = new NativeSearchQueryBuilder().withQuery(filters2)  
                .withSort(new FieldSortBuilder("id").ignoreUnmapped(true).order(SortOrder.DESC)).build();  
        pp=clienteDao.search(sq);
        iter=pp.iterator();
        while(iter.hasNext()){
        	System.out.println(iter.next());
        }
        
        LOG.info(" get cliente by id {} is {}", id, cliente);
        return cliente;
    }
}
