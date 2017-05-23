package com.qf.farmer.es.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

/**
 * 店铺实体
 * @author qinfei
 *
 */
@Document(indexName = "farmer", type = "store", shards = 1, replicas = 0, refreshInterval = "-1")
public class Store {

	@Id
	private String id;
	private String storeName;
	private String storeDesc;
	private String storeAdPic;
	private String storeType;
	private String addRess;
	private String storeDomain;
	private String storeTel;
	private int operationTimeBegin;
	private int operationTimeEnd;
	private int storeScore;
	private int totalBrowseCount;
	@GeoPointField
    private GeoPoint location;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreDesc() {
		return storeDesc;
	}
	public void setStoreDesc(String storeDesc) {
		this.storeDesc = storeDesc;
	}
	public String getStoreAdPic() {
		return storeAdPic;
	}
	public void setStoreAdPic(String storeAdPic) {
		this.storeAdPic = storeAdPic;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getAddRess() {
		return addRess;
	}
	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}
	public String getStoreDomain() {
		return storeDomain;
	}
	public void setStoreDomain(String storeDomain) {
		this.storeDomain = storeDomain;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public int getOperationTimeBegin() {
		return operationTimeBegin;
	}
	public void setOperationTimeBegin(int operationTimeBegin) {
		this.operationTimeBegin = operationTimeBegin;
	}
	public int getOperationTimeEnd() {
		return operationTimeEnd;
	}
	public void setOperationTimeEnd(int operationTimeEnd) {
		this.operationTimeEnd = operationTimeEnd;
	}
	public int getStoreScore() {
		return storeScore;
	}
	public void setStoreScore(int storeScore) {
		this.storeScore = storeScore;
	}
	public int getTotalBrowseCount() {
		return totalBrowseCount;
	}
	public void setTotalBrowseCount(int totalBrowseCount) {
		this.totalBrowseCount = totalBrowseCount;
	}
	public GeoPoint getLocation() {
		return location;
	}
	public void setLocation(GeoPoint location) {
		this.location = location;
	}
}
