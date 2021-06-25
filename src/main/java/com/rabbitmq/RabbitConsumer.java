package com.rabbitmq;

import javax.jms.Message;

import com.activemq.classic.ActiveMQConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConsumer {
	private Connection myConnection;
	private Channel myChannel;
	private final String QUEUE_NAME = "MyQueue";

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		try {
			myConnection = myFactory.newConnection();
			myChannel = myConnection.createChannel();
			myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RabbitConsumer() {
		makeConnection();
	}
	
	public void closeConnection() {
		try {
			myChannel.close();
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				// String msg = new String(myChannel.basicGet(QUEUE_NAME, true).getBody());
				myChannel.basicGet(QUEUE_NAME, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void synchronousConsume() {
		while (true) {
			try {
				myChannel.basicGet(QUEUE_NAME, true);
				System.out.println("Message received");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		RabbitConsumer myConsumer = new RabbitConsumer();
		myConsumer.synchronousConsume();
	}

}
