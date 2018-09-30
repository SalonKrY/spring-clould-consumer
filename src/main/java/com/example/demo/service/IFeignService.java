package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")
public interface IFeignService {

	@RequestMapping("test/testRibbon")
	public String testFeign(); 
}
