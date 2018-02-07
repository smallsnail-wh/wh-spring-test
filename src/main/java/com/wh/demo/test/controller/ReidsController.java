package com.wh.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class ReidsController {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@GetMapping("/string")
	public String string() {
		return "SUCCESS";
	}

	@GetMapping("/hash")
	public String hash() {
		return "SUCCESS";
	}

	@GetMapping("/list")
	public String list() {
		
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		ListOperations<String, Object> listOperations = redisTemplate.opsForList();
		
		listOperations.rightPush("list", "a");
		listOperations.rightPush("list", "b");
		listOperations.rightPush("list", "c");
		
		return "SUCCESS";
	}
	
	@GetMapping("/list/pop")
	public String listPop() {
		return (String) redisTemplate.opsForList().leftPop("list");
	}

	@GetMapping("/set")
	public String set() {
		return "SUCCESS";
	}

	@GetMapping("/zset")
	public String zset() {
		return "SUCCESS";
	}

}
