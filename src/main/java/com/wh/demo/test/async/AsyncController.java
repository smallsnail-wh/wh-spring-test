package com.wh.demo.test.async;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	private DeferredResultEntity deferredResultEntity;
	
	private Logger log = LoggerFactory.getLogger(AsyncController.class);
	
	@GetMapping("/callable")
	public Callable<String> testCallable() throws InterruptedException {
		log.info("主线程开始！");
		Callable<String> result = new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				log.info("副线程开始！");
				Thread.sleep(1000);
				log.info("副线程结束！");
				return "SUCCESS";
			}
			
		};
		log.info("主线程结束！");
		return result;
	}
	
	@GetMapping("/deferred")
	public DeferredResult<Object> testDeferredResult() {
		log.info("主线程开始！");
		DeferredResult<Object> result = new DeferredResult<Object>();
		deferredResultEntity.setResult(result);
		deferredResultEntity.setFlag(true);
		log.info("主线程结束！");
		return result;
	}
	
}
