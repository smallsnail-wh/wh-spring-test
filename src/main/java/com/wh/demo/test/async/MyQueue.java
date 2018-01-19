package com.wh.demo.test.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyQueue {
	
	Logger log = LoggerFactory.getLogger(getClass());

	private String placeOrder;
	
	private String completeOrder;

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws Exception {
		new Thread(() -> {
			log.info("收到下单请求");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.completeOrder = placeOrder;
			log.info("下单请求完成，"+placeOrder);
		}).start();
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}

}
