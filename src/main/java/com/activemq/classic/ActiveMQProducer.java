/*
 * Copyright 2021 JKOOL, LLC.
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
	// PARAMS
	private final boolean PERSISTENCE = false;

	private static String QUEUE_NAME = "MyQueue";
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

			if (PERSISTENCE) {
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			} else {
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}

			connection.start();

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ActiveMQProducer() {
		makeConnection();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] byteArrMsg = new byte[msgSize];
		try {
			BytesMessage message = session.createBytesMessage();
			message.writeBytes(byteArrMsg);

			for (int counter = 0; counter < totalMessages; counter++) {
				producer.send(message);
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

	public static void main(String[] args) {
		// populates queues for the consumer benchmarks
		QUEUE_NAME = "MyQueue1";
		ActiveMQProducer p1 = new ActiveMQProducer();
		p1.produce(130000, 512);
		p1.closeConnection();

		QUEUE_NAME = "MyQueue2";
		ActiveMQProducer p2 = new ActiveMQProducer();
		p2.produce(130000, 1024);
		p2.closeConnection();

		QUEUE_NAME = "MyQueue3";
		ActiveMQProducer p3 = new ActiveMQProducer();
		p3.produce(130000, 10240);
		p3.closeConnection();

		QUEUE_NAME = "MyQueue4";
		ActiveMQProducer p4 = new ActiveMQProducer();
		p4.produce(130000, 32768);
		p4.closeConnection();

		QUEUE_NAME = "MyQueue5";
		ActiveMQProducer p5 = new ActiveMQProducer();
		p5.produce(130000, 65536);
		p5.closeConnection();
	}

}
