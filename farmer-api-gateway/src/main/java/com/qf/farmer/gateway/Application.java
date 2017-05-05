package com.qf.farmer.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 提供了一个jsp页面。通过这个页面我们可以知道gateway以及其他在eureka server上注册的服务的健康状况，并且这个注解包含了@EnableZuulProxy，所以呢，它也支持软负载均衡，如果启动多个服务，通过gateway来调用这个接口，多次调用我们会发现，请求会落在不同的服务上
 * @author qinfei
 *
 */
@SpringBootApplication
@EnableSidecar
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
