package com.qf.farmer.recommend.util;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import java.io.Serializable;

@SuppressWarnings("all")
public class SparkBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public static JavaStreamingContext getStreamingContext(String appName, String masterURL, Integer time) {
        try {
            SparkConf sparkConf = new SparkConf().setAppName(appName).setMaster(masterURL);
            JavaStreamingContext context = new JavaStreamingContext(sparkConf, new Duration(time));
            return context;
        } catch (Exception e) {
            throw new RuntimeException("程序运行异常！");
        }
    }
}
