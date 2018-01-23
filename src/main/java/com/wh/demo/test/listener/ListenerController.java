package com.wh.demo.test.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listener")
public class ListenerController {

	@Autowired
	private MyApplicationEventService myApplicationEventService;
	
	@GetMapping("/listener")
	public String testMyListener() {
		/*myApplicationEventService.sendEmail("john.doe@example.org", "123123"); */
		myApplicationEventService.testListener("john.doe@example.org", "23");
		/*new MyTestListener().testListenr(new MyApplicationEvent(new Object(),"smallsnail-wh@example.org", "123123"));*/
		return "SUCCESS";
	}
	
}
