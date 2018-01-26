package com.wh.demo.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("1")
	public Map test() {
		
		Map<String,Object> result = new HashMap();
		result.put("id", 1);
		result.put("name", "wanghuan");
		
		return result;
	}

}
