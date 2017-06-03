package com.qf.farmer.recommend.stream;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import com.qf.farmer.recommend.domain.Goods;

public class Recommend implements Serializable {
	private static final long serialVersionUID = 1L;
	private JavaSparkContext ctx;

	public void train(){
		SparkConf conf=new SparkConf();
		conf.setAppName("train");
		ctx = new JavaSparkContext(conf);
		JavaRDD<String> lines=ctx.textFile("hdfs://qf/user/hive/warehouse/goods/",64);
		JavaRDD<Goods> goods=lines.map(new Function<String, Goods>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Goods call(String line) throws Exception {
				String[] split=line.split("\001",-1);
				Goods g=new Goods();
				g.setId(split[0]);
				g.setName(split[1]);
				return g;
			}
		});
		goods=goods.filter(new Function<Goods, Boolean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Boolean call(Goods g) throws Exception {
				return StringUtils.isNotBlank(g.getType());
			}
		});
	}
}
