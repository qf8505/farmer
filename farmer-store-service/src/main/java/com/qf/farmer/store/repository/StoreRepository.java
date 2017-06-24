package com.qf.farmer.store.repository;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.qf.farmer.store.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	/**
	 * 对店铺表使用读锁，@Lock(LockModeType.PESSIMISTIC_WRITE)  方式是写锁，写锁会导致其他事务无法进行并行锁操作
	 * select ... FOR UPDATE同时只能有一个在语句执行，另一个会阻塞；select ... LOCK IN SHARE MODE可以多个同时执行
	 * 特例：for udpate对使用唯一索引和主键这类保证唯一数据加锁(此类为行级锁，其他为表级锁)，不会对其他事物加锁有影响
	 * @param storeName
	 * @Query("select u from Store u where u.storeName= ?")  
	 * @return
	 */
	@Lock(LockModeType.PESSIMISTIC_READ)
	List<Store> findByStoreName(String storeName);

}
