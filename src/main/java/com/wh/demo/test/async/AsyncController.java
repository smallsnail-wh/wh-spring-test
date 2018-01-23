package com.wh.demo.test.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsyncController {

	@Autowired
	private MyQueue myQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	private Logger log = LoggerFactory.getLogger(AsyncController.class);
	
	@RequestMapping("/order")
	public DeferredResult<String> order() throws Exception {
		log.info("主线程开始！");
		
		String orderNumber = RandomStringUtils.randomNumeric(8);
		myQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<String>();
		deferredResultHolder.getMap().put(orderNumber, result);
		/*Callable<String> result = new Callable<String>() {

			@Override
			public String call() throws Exception {
				log.info("副线程开始");
				Thread.sleep(1000);
				log.info("副线程结束");
				return "SUCCESS";
			}
			
		};*/
		log.info("主线程结束！");
		return result;
	}
	
}
