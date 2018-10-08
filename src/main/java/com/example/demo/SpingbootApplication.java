package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@EnableZuulProxy
public class SpingbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingbootApplication.class, args);
	}
}
