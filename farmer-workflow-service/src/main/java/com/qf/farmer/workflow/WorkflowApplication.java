package com.qf.farmer.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * activiti工作流
 * 
 * @author qinfei
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WorkflowApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);
	}
}
