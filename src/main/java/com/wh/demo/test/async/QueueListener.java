package com.wh.demo.test.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;


//@Component
public class QueueListener implements ApplicationListener<RequestHandledEvent> {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MyQueue myQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;

	@Override
	public void onApplicationEvent(RequestHandledEvent event) {
		System.out.println("this is listener");
		/*new Thread(() ->{
			a:while(true) {
				if(StringUtils.isNotBlank(myQueue.getCompleteOrder())) {
					
					String orderNumber = myQueue.getCompleteOrder();
					log.info("返回订单处理结果"+orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place roder success");
					
					myQueue.setCompleteOrder(null);
					System.out.println("this listener break");
					break a;
				}else {
					try {
						System.out.println("this is listener");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();*/
	}
	
}
