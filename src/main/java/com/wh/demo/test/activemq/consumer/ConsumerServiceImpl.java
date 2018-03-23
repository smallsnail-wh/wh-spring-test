package com.wh.demo.test.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;

public class ConsumerServiceImpl implements ConsumerService {

	@Override
	@JmsListener(destination="")
	public void receiveQueueMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receiveTopicMessage() {
		// TODO Auto-generated method stub
		
	}

}
