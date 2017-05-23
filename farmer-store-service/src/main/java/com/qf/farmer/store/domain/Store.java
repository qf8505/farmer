package com.qf.farmer.store.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String storeName;
	@Column
	private String storeDesc;
	@Column
	private String storeAdPic;
	@Column
	private String storeType;
	@Column
	private String addRess;
	@Column
	private String storeDomain;
	@Column
	private String storeTel;
	@Column
	private int operationTimeBegin;
	@Column
	private int operationTimeEnd;
	@Column
	private int storeStatus;
	@Column
	private int approvalStatus;
	@Column
	private int signStatus;
	@Column
	private int storeScore;
	@Column
	private int totalBrowseCount;
	@Column
	private double lon;
	@Column
	private double lat;
	@Column

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public int getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(int storeStatus) {
		this.storeStatus = storeStatus;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(int signStatus) {
		this.signStatus = signStatus;
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

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}
