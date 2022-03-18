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
package com.tibco;

import com.tibco.tibjms.TibjmsQueueConnectionFactory;

import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;

public class TibcoConsumer {
	
	private Destination destination;
	private Queue queue = null;
	private Connection connection;
	private Session session;
	private MessageConsumer consumer;
	

	public void buildConnection() {
		try {
			ConnectionFactory cf = new com.tibco.tibjms.TibjmsConnectionFactory("tcp://localhost:7222");
			connection = cf.createConnection("admin", "admin");
			session = connection.createSession(javax.jms.Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public TibcoConsumer() {
		buildConnection();
	}
	
	public void consume(int msgsToRead, String QUEUE_NAME) {
		try {
			if (destination == null) {
				destination = session.createQueue(QUEUE_NAME);
				consumer = session.createConsumer(destination);
				connection.start();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		for (int count = 0; count < msgsToRead; count++) {
			try {
				BytesMessage msg = (BytesMessage) consumer.receive();
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
		int x= 0,
		y = 0;
		try {
			if (destination == null) {
				destination = session.createQueue(QUEUE_NAME);
				consumer = session.createConsumer(destination);
				connection.start();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		while (true) {
			try {
				BytesMessage msg = (BytesMessage) consumer.receive();
				x++;y++;
				if (y == 100) {
					System.out.println("Current message: " + x);
					y = 0;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		TibcoConsumer consumer = new TibcoConsumer();
		consumer.concurrentConsume("ConcurrentQueue");
		consumer.closeConnection();
	}
	
}
