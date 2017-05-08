package com.qf.farmer.neo.util;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//启动类的@SpringBootApplication会自动扫描同级包以及子包，所以下面的@ComponentScan不加应该没关系
//@ComponentScan("cn.didadu.sdn")
@EnableNeo4jRepositories("com.qf.farmer.repository")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {
	
    @Override
    public SessionFactory getSessionFactory() {

    	return new SessionFactory("com.qf.farmer.domain.entity");
    }
}