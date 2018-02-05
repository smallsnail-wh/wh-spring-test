/*package com.wh.demo.test.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyTask {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Scheduled(initialDelayString="10000",fixedDelayString="5000")
	public void taskTest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("123123");
	}
	
}
*/