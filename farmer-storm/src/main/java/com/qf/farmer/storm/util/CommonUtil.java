package com.qf.farmer.storm.util;

/** 
 * @ClassName: CommonUtil 
 * @Description: TODO
 * @author: qinfei
 * @date: 2016年7月4日 下午5:24:27 
 */
public class CommonUtil {

	public static final String KEY_JOIN_TYPE="_";
	public static final String VALUE_JOIN_TYPE="\001";
	public static final String KEY_TOP="ahisrd";
	
	public static final String DATA_TO_REDIS="datatoredis";
	public static final String DATA_TO_HDFS="datatohdfs";
	public static final String REDIS="172.31.10.151";
	
	public static final String SPOUT="searchHisSpout";
	public static final String ZKSTR="172.31.8.1:2181,172.31.8.2:2181,172.31.8.3:2181";
	public static final String TOPIC="farmer-store";
	public static final String ZKROOT="/farmer";
	public static final String SPORTID="farmer";
	public static final String ZKLIST="172.31.8.1,172.31.8.2,172.31.8.3";
	public static final String SPLIT=",";
	public static final String HDFS="hdfs://172.31.8.1:9000";
	public static final String NAME="farmer";
}
