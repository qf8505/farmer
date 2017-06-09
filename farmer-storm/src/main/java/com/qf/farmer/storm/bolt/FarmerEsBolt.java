package com.qf.farmer.storm.bolt;

import java.util.Map;

import org.elasticsearch.storm.EsBolt;

/**
 * 自定义storm-es-bolt
 * @author qinfei
 *
 */
public class FarmerEsBolt extends EsBolt {

	private static final long serialVersionUID = 1425464917147906083L;
	
	public FarmerEsBolt(String target, Map<Object, Object> boltConf) {
		super(target, boltConf);
	}

}