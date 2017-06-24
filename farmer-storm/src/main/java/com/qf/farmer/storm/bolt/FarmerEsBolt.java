package com.qf.farmer.storm.bolt;

import java.util.Map;

import org.elasticsearch.storm.EsBolt;

import backtype.storm.tuple.Tuple;

/**
 * 自定义storm-es-bolt
 * @author qinfei
 *
 */
public class FarmerEsBolt extends EsBolt {

	private static final long serialVersionUID = 1425464917147906083L;
	
	public FarmerEsBolt(Map<Object, Object> boltConf) {
		super("farmer/store", boltConf);
	}
	
	@Override
	public void execute(Tuple input) {
		super.execute(input);
	}
}
