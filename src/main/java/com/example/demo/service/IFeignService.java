package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service", fallback = FeignServiceFallBack.class)
public interface IFeignService {

	@RequestMapping("test/testRibbon")
	public String testFeign(); 
}
