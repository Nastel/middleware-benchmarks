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
	private Destination destination = null;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;

	public void makeConnection() {
		try {
			String url = ActiveMQConnection.DEFAULT_BROKER_URL;
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			connection = connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ActiveMQConsumer() {
		makeConnection();
	}

	public void consume(int messagesToRead, String QUEUE_NAME) {
		try {
			if (destination == null) {
				destination = session.createQueue(QUEUE_NAME);
				consumer = session.createConsumer(destination);
				connection.start();
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}

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

	public void concurrentConsume(String QUEUE_NAME) {
		try {
			if (destination == null) {
				destination = session.createQueue(QUEUE_NAME);
				consumer = session.createConsumer(destination);
				connection.start();
			}
		} catch (JMSException e1) {
			e1.printStackTrace();
		}

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
		myConsumer.concurrentConsume("MyQueue");
		myConsumer.closeConnection();
	}

}
