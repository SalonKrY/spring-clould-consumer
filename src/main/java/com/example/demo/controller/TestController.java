package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.User;
import com.example.demo.service.IFeignService;
import com.example.demo.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="测试接口Controller类",tags= {"测试接口"})
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private IUserService userService;
	
	@ApiOperation("第一个程序")
	@GetMapping("/hw")
//	跨域局部配置
//	@CrossOrigin(origins="http://localhost:8088")
	public String hw() {
		return "hello world";
	}
	
	@GetMapping("/wait")
	public String w() {
		return "wait la";
	}
	
	@GetMapping("/testUser")
	public User testUser() {
		User user = new User();
		user.setId("1");
		user.setUserName("test");
		user.setPassword("test");
		user.setBirthday(new Date());
		return user;
	}
	
	@GetMapping("/testException")
	public User testException() throws Exception {
		 throw new Exception("发生异常");
	}
	
	@GetMapping("/testRibbon")
	public String testRibbon() {
		return userService.getTestRibbon();
	}
	
	@Autowired
	private IFeignService feignService;
	
	@GetMapping("/testFeign")
	public String testFeign() {
		return feignService.testFeign();
	}
	
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@GetMapping("/testRedis")
	public String testRedis() {
	    redisTemplate.opsForValue().set("a", "1");
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);
        return a.toString();
	}
	
}
