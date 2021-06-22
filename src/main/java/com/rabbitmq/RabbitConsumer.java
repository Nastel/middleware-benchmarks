package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitConsumer {
	private String QUEUE_NAME;
	private Connection myConnection;
	private Channel myChannel;

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

	public RabbitConsumer(String msgSize) {
		QUEUE_NAME = "Queue." + msgSize;
		makeConnection();
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				// String msg = new String(myChannel.basicGet(QUEUE_NAME, true).getBody());
				myChannel.basicGet(QUEUE_NAME, true);
				System.out.println("Received message " + counter + " of " + messagesToRead);
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

//	public static void main(String[] args) {}

}
