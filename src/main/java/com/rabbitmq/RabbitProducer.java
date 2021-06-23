package com.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class RabbitProducer {
	private final String QUEUE_NAME = "MyQueue";
	private Connection myConnection;
	private Channel myChannel;

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		try {
			myConnection = myFactory.newConnection();
			myChannel = myConnection.createChannel();
			// create durable queue (lasts on broker restart)
			myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RabbitProducer() {
		makeConnection();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] byteArrMsg = new byte[msgSize];
		try {

			for (int counter = 0; counter < totalMessages; counter++) {
				// use default exchange
				myChannel.basicPublish("", QUEUE_NAME, null, byteArrMsg);
				System.out.println("Message " + counter + " sent to queue");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
