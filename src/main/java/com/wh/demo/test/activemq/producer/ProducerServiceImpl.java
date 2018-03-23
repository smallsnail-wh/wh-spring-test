package com.wh.demo.test.activemq.producer;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Override
	public void sendQueueMessage(String queueName,String message) {
		System.out.println("============>>>>> 发送queue消息 " + message);
		Destination destination = new ActiveMQQueue(queueName);
		jmsMessagingTemplate.convertAndSend(destination,message);
	}

	@Override
	public void sendTopicMessage(String topicName, String message) {
		System.out.println("============>>>>> 发布topic消息 " + message);
		Destination destination = new ActiveMQTopic(topicName);
        jmsMessagingTemplate.convertAndSend(destination, message);
	}

}
