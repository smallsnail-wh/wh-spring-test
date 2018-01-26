package com.wh.demo.test.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/onceperrequestfilter")
	public String oncePerRequestFilterTest() {
		log.info("FilterController处理");
		return "SUCCESS";
	}
	
	
}
