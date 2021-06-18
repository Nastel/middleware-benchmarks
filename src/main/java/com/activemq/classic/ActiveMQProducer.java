package com.activemq.classic;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQProducer {
	private final String QUEUE_NAME = "testEE";
	private Connection connection;
	private Session session;
	private MessageProducer producer;
	private Destination destination;

	
	public void makeConnection() {
		try {
		    String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	        connection = connectionFactory.createConnection();
	        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        destination = session.createQueue(QUEUE_NAME);
	        producer = session.createProducer(destination);
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        connection.start();

		}catch(JMSException e) {
			e.printStackTrace();
		}
	}
	
	public ActiveMQProducer() {
		makeConnection();
		
	}
	public void produce(int totalMessages, int msgSize){
		byte[] byteArrMsg = new byte[msgSize];
		try {
			BytesMessage message = session.createBytesMessage();
			message.writeBytes(byteArrMsg);

			for (int counter = 0; counter < totalMessages; counter++) {
				producer.send(message);
				System.out.println("Message " + counter + " sent to queue");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws JMSException {
		ActiveMQProducer producer = new ActiveMQProducer();
		producer.produce(1000, 1024);
		producer.closeConnection();
	}

}