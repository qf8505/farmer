package com.qf.farmer.ui.domain;

/**
 * 店铺实体
 * @author qinfei
 *
 */
public class Store {

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
	private int storeStatus;
	private int approvalStatus;
	private int signStatus;
	private int storeScore;
	private int totalBrowseCount;
	private double lon;
	private double lat;
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
