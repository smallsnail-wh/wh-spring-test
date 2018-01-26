package com.wh.demo.test.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MyQueue myQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	@Autowired
	private DeferredResultEntity deferredResultEntity;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*new Thread(() ->{
			while(true) {
				if(StringUtils.isNotBlank(myQueue.getCompleteOrder())) {
					
					String orderNumber = myQueue.getCompleteOrder();
					log.info("返回订单处理结果"+orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place roder success");
					
					myQueue.setCompleteOrder(null);
					System.out.println("this listener break");
				}else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();*/
	}
	
}
