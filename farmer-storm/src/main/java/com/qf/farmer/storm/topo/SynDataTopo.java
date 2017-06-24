package com.qf.farmer.storm.topo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.storm.hdfs.bolt.HdfsBolt;
import org.apache.storm.hdfs.bolt.format.DefaultFileNameFormat;
import org.apache.storm.hdfs.bolt.format.DelimitedRecordFormat;
import org.apache.storm.hdfs.bolt.format.FileNameFormat;
import org.apache.storm.hdfs.bolt.format.RecordFormat;
import org.apache.storm.hdfs.bolt.rotation.FileRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy;
import org.apache.storm.hdfs.bolt.rotation.FileSizeRotationPolicy.Units;
import org.apache.storm.hdfs.bolt.sync.CountSyncPolicy;
import org.apache.storm.hdfs.bolt.sync.SyncPolicy;

import com.qf.farmer.storm.bolt.FarmerEsBolt;
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
 * storm kill -w 5 farmer 
 * sleep 10 
 * storm jar farmer-storm-0.0.1-SNAPSHOT.jar com.qf.farmer.storm.topo.SynDataTopo
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
			config.ignoreZkOffsets=true;
			config.maxOffsetBehind = 10000;
			config.zkServers = Arrays.asList(CommonUtil.ZKLIST.split(CommonUtil.SPLIT));
			config.zkPort = 2181;
			builder.setSpout(CommonUtil.SPOUT, new KafkaSpout(config));
			builder.setBolt(FilterBolt.class.getSimpleName(), new FilterBolt()).shuffleGrouping(CommonUtil.SPOUT);
			RecordFormat format = new DelimitedRecordFormat().withFieldDelimiter(CommonUtil.VALUE_JOIN_TYPE);
			SyncPolicy syncPolicy = new CountSyncPolicy(1000);
			//设置hdfs文件大小
			FileRotationPolicy rotationPolicy = new FileSizeRotationPolicy(128.0f, Units.MB);
			FileNameFormat fileNameFormat = new DefaultFileNameFormat().withPath("/farmer/").withPrefix("his_").withExtension(".log");
			HdfsBolt hdfsBolt = new HdfsBolt().withFsUrl(CommonUtil.HDFS).withFileNameFormat(fileNameFormat)
					.withRecordFormat(format).withRotationPolicy(rotationPolicy).withSyncPolicy(syncPolicy);
			//保存到hdfs中
			builder.setBolt(HdfsBolt.class.getSimpleName(), hdfsBolt, 3).fieldsGrouping(FilterBolt.class.getSimpleName(),CommonUtil.DATA_TO_HDFS, new Fields("id"));
			Map<Object, Object> boltConf = new HashMap<Object, Object>();  
	        boltConf.put("es.nodes", CommonUtil.ES);  
	        boltConf.put("es.input.json", "true");//以json的方式提交数据，否则会按照字符串处理
	        boltConf.put("es.index.auto.create", "true");//自动创建索引
	        boltConf.put("es.batch.size.entries", 1);//es内部默认缓存为1000，会导致无法将更新实时提交的es服务器
	        //curl -XDELETE 'http://172.31.7.1:9200/farmer'删除索引
			builder.setBolt(FarmerEsBolt.class.getSimpleName(), new FarmerEsBolt(boltConf), 3).fieldsGrouping(FilterBolt.class.getSimpleName(),CommonUtil.DATA_TO_ES, new Fields("id"));

			Config conf = new Config();
			conf.setDebug(false);
			conf.setNumWorkers(5);
//			if(args!=null&&args.length!=0){
//				LocalCluster cluster = new LocalCluster();//storm本地调试模式
//				cluster.submitTopology(CommonUtil.NAME, conf, builder.createTopology());
//				Thread.sleep(10000);
//				cluster.shutdown();
//			}else{
				StormSubmitter.submitTopology(CommonUtil.NAME, conf, builder.createTopology());
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
