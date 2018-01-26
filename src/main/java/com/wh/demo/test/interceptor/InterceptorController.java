package com.wh.demo.test.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/test")
	public String test() {
		log.info("InterceptorController处理");
		return "SUCCESS";
	}
	
}
