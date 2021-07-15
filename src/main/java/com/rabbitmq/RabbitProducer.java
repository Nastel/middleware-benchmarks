/*
 * Copyright 2014-2018 JKOOL, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;

public class RabbitProducer {
	// PARAMS
	private final boolean PERSISTENCE = false;

	private static String QUEUE_NAME = "MyQueue";
	private Connection myConnection;
	private Channel myChannel;
	private BasicProperties prop;

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		if (PERSISTENCE) {
			prop = MessageProperties.PERSISTENT_TEXT_PLAIN;
		} else {
			prop = MessageProperties.TEXT_PLAIN;
		}

		try {
			myConnection = myFactory.newConnection();
			myChannel = myConnection.createChannel();
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
				myChannel.basicPublish("", QUEUE_NAME, prop, byteArrMsg);

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

	public static void main(String[] args) {
		// populates queues for the consumer benchmarks
		QUEUE_NAME = "myQueue1";
		RabbitProducer p1 = new RabbitProducer();
		p1.produce(130000, 512);
		p1.closeConnection();

		QUEUE_NAME = "myQueue2";
		RabbitProducer p2 = new RabbitProducer();
		p2.produce(130000, 1024);
		p2.closeConnection();

		QUEUE_NAME = "myQueue3";
		RabbitProducer p3 = new RabbitProducer();
		p3.produce(130000, 10240);
		p3.closeConnection();

		QUEUE_NAME = "myQueue4";
		RabbitProducer p4 = new RabbitProducer();
		p4.produce(130000, 32768);
		p4.closeConnection();

		QUEUE_NAME = "myQueue5";
		RabbitProducer p5 = new RabbitProducer();
		p5.produce(130000, 65536);
		p5.closeConnection();
	}

}
