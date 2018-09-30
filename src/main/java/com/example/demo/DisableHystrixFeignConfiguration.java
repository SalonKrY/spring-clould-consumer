package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import feign.Feign;

//@Configuration
public class DisableHystrixFeignConfiguration {
	
	@Bean    
	@Scope("prototype")    
	public Feign.Builder feignHystrixBuilder() {        
		return Feign.builder();    
	}
}
