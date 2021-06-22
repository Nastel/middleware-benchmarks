package com.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class RabbitProducer {
	private static final String QUEUE_NAME = "TestQueue";

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		// try-with-resources to auto close the connection and channel after try block
		// is completed
		try (Connection myConnection = myFactory.newConnection(); Channel myChannel = myConnection.createChannel();) {
			myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
			String message = "Hello world";
			myChannel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("sent msg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RabbitProducer() {
		makeConnection();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RabbitProducer p = new RabbitProducer();
	}

}
