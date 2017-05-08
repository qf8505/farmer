package com.qf.farmer.md.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoConfiguration {

  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient();
  }

  @Override
  protected String getDatabaseName() {
    return "springdata";
  }
}