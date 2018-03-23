package com.wh.demo.test.activemq.producer;

public interface ProducerService {
	
	/**
	 * 发送队列消息
	 * @param queueName
	 * @param message
	 */
	void sendQueueMessage(String queueName,String message);
	
	/**
	 * 发送主题消息
	 * @param topicName
	 * @param message
	 */
	void sendTopicMessage(String topicName,String message);
	
}
