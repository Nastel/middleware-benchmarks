package com.activemq.classic;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQConsumer {
	private final String QUEUE_NAME = "MyQueue";
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	private Destination destination;

	public void makeConnection() {
		try {
			String url = ActiveMQConnection.DEFAULT_BROKER_URL;
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(QUEUE_NAME);
			consumer = session.createConsumer(destination);
			connection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ActiveMQConsumer() {
		makeConnection();
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				BytesMessage message = (BytesMessage) consumer.receive();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void synchronousConsume() {
		while (true) {
			try {
				BytesMessage message = (BytesMessage) consumer.receive();
				System.out.println("Message received");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ActiveMQConsumer myConsumer = new ActiveMQConsumer();
		myConsumer.synchronousConsume();
	}

}
