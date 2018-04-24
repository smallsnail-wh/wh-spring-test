/*package com.wh.demo.test.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppConsumer {
	
	private static final String url = "tcp://127.0.0.1:61616";

	private static final String topicName = "topic-test";

	@GetMapping("/consumer")
	public String consumer() throws JMSException {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);

		Connection connection = connectionFactory.createConnection();

		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic(topicName);

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage  textMessage =  (TextMessage) message;
				try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		return "SECCUSS";
	}
}
*/