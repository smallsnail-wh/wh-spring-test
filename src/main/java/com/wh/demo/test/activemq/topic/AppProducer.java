/*package com.wh.demo.test.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppProducer {

	private static final String url = "tcp://127.0.0.1:61616";
	
	private static final String topicName = "topic-test";

	@GetMapping("/producer")
	public String producer() throws JMSException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createTopic(topicName);
		
		MessageProducer messageProducer = session.createProducer(destination);
		
		TextMessage textMessage = session.createTextMessage("holle world!");
		
		messageProducer.send(textMessage);
		
		session.commit();
		session.close();
		connection.close();
		
		return "SECCUSS";
	}
	
}
*/