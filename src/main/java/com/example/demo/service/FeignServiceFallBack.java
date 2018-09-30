package com.example.demo.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements IFeignService{

	@Override
	public String testFeign() {
		return "testFeign hystrix ====== fail at" + new Date();
	}

}
