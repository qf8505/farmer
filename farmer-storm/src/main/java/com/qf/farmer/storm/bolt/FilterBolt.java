package com.qf.farmer.storm.bolt;

import com.qf.farmer.storm.util.CommonUtil;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/** 
 * @ClassName: FilterBolt 
 * @Description: TODO
 * @author: qinfei
 * @date: 2016年7月4日 下午4:20:23 
 */
public class FilterBolt extends BaseBasicBolt {

	/**
	 * @fieldName serialVersionUID
	 * @fieldType long
	 * @Description TODO
	 */
	private static final long serialVersionUID = 1611973389057201599L;

	@Override
	public void execute(Tuple input, BasicOutputCollector collector) {
		String line=input.getString(0);
		collector.emit(CommonUtil.DATA_TO_REDIS, new Values(line));
		collector.emit(CommonUtil.DATA_TO_HDFS, new Values(line));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declareStream(CommonUtil.DATA_TO_REDIS, new Fields("id"));
		declarer.declareStream(CommonUtil.DATA_TO_HDFS, new Fields("id"));
	}

}
