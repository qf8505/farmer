package com.qf.farmer.storm.topo;

import java.util.Arrays;

import org.apache.storm.hdfs.bolt.HdfsBolt;
import org.apache.storm.hdfs.bolt.format.DefaultFileNameFormat;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.format.FileNameFormat;
import org.apache.storm.hdfs.bolt.format.RecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy.Units;
import org.apache.storm.hdfs.bolt.rotation.TimedRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.TimedRotationPolicy.TimeUnit;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;
import org.elasticsearch.storm.EsBolt;

import com.qf.farmer.storm.bolt.FilterBolt;
import com.qf.farmer.storm.util.CommonUtil;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

/**
 * @ClassName: 处理业务发送的同步消息,将数据同步到es上
 * @Description: TODO
 * @author: qinfei
 * @date: 2016年7月4日 上午9:52:58
 */
public class SynDataTopo {

	public static void main(String[] args) {
		try{
			TopologyBuilder builder = new TopologyBuilder();
			BrokerHosts hosts = new ZkHosts(CommonUtil.ZKSTR);
			SpoutConfig config = new SpoutConfig(hosts, CommonUtil.TOPIC,CommonUtil.ZKROOT , CommonUtil.SPORTID);
			config.scheme = new SchemeAsMultiScheme(new StringScheme());
//			config.forceFromStart = true;
			config.maxOffsetBehind = 10000;
			config.zkServers = Arrays.asList(CommonUtil.ZKLIST.split(CommonUtil.SPLIT));
			config.zkPort = 2181;
			builder.setSpout(CommonUtil.SPOUT, new KafkaSpout(config));
			builder.setBolt(FilterBolt.class.getSimpleName(), new FilterBolt()).shuffleGrouping(CommonUtil.SPOUT);
			RecordFormat format = new DelimitedRecordFormat().withFieldDelimiter(CommonUtil.VALUE_JOIN_TYPE);
			SyncPolicy syncPolicy = new CountSyncPolicy(1000);
			//设置hdfs文件大小
			FileRotationPolicy rotationPolicy = new FileSizeRotationPolicy(128.0f, Units.MB);
			FileNameFormat fileNameFormat = new DefaultFileNameFormat().withPath("/searchHis/").withPrefix("his_").withExtension(".log");
			HdfsBolt hdfsBolt = new HdfsBolt().withFsUrl(CommonUtil.HDFS).withFileNameFormat(fileNameFormat)
					.withRecordFormat(format).withRotationPolicy(rotationPolicy).withSyncPolicy(syncPolicy);
			//保存到hdfs中
			builder.setBolt(HdfsBolt.class.getSimpleName(), hdfsBolt, 3).fieldsGrouping(FilterBolt.class.getSimpleName(),CommonUtil.DATA_TO_HDFS, new Fields("id"));
			builder.setBolt(EsBolt.class.getSimpleName(), new EsBolt("/farmer/store"), 3).fieldsGrouping(FilterBolt.class.getSimpleName(),CommonUtil.DATA_TO_REDIS, new Fields("id"));

			Config conf = new Config();
			conf.setDebug(false);
			conf.setNumWorkers(5);
			StormSubmitter.submitTopology(CommonUtil.NAME, conf, builder.createTopology());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}