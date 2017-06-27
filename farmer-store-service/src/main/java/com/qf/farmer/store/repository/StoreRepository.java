package com.qf.farmer.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qf.farmer.store.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	List<Store> findByStoreName(String storeName);

}
