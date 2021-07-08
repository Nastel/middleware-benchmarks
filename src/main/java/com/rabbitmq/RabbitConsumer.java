package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitConsumer {
	private Connection myConnection;
	private Channel myChannel = null;

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		try {
			myConnection = myFactory.newConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RabbitConsumer() {
		makeConnection();
	}

	public void consume(int messagesToRead, String QUEUE_NAME) {
		if (myChannel == null) {
			try {
				myChannel = myConnection.createChannel();
				myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				// String msg = new String(myChannel.basicGet(QUEUE_NAME, true).getBody());
				myChannel.basicGet(QUEUE_NAME, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			myChannel.close();
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void concurrentConsume(String QUEUE_NAME) {
		if (myChannel == null) {
			try {
				myChannel = myConnection.createChannel();
				myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				delivery.getBody();
			};
			myChannel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		RabbitConsumer myConsumer = new RabbitConsumer();
		myConsumer.concurrentConsume("MyQueue");
		myConsumer.closeConnection();
	}

}
