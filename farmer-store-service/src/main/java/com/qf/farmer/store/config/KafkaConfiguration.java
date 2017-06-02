package com.qf.farmer.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * 启用kafka配置,需要springboot1.5以上版本,
 * kafka2.11-0.10.0.0以上版本，否则会超时
 * @author qinfei
 *
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

}