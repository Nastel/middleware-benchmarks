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

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class TibcoProducer {

	private static String QUEUE_NAME = "ConcurrentQueue";
	private Connection connection;
	private Session session;
	private Destination destination;
	private MessageProducer producer;

	private final boolean PERSISTENCE = true;

	private void buildConnection() {
		// TibjmsQueueConnectionFactory qCF = new
		// TibjmsQueueConnectionFactory("tcp://localhost:7222");
		try {
			ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory("tcp://localhost:7222");
			connection = factory.createConnection("admin", "admin");
			session = connection.createSession(javax.jms.Session.AUTO_ACKNOWLEDGE);
			
			
			destination = session.createQueue(QUEUE_NAME);
			producer = session.createProducer(destination);

			if (PERSISTENCE) {
				producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			} else {
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public TibcoProducer() {
		buildConnection();
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void produce(int totalMsgs, int msgSize) {
		byte[] byteArrMsg = new byte[msgSize];

		try {
			BytesMessage msg = session.createBytesMessage();
			msg.writeBytes(byteArrMsg);

			for (int count = 0; count < totalMsgs; count++) {
				
				producer.send(msg);

			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { // Used to populate queues for Consumer
//		QUEUE_NAME = "ConsumeQueue1";
//		TibcoProducer p1 = new TibcoProducer();
//		p1.produce(130000, 512);
//		p1.closeConnection();
//		System.out.println("QUEUE1 OK.");
//
//		QUEUE_NAME = "ConsumeQueue2";
//		TibcoProducer p2 = new TibcoProducer();
//		p2.produce(130000, 1024);
//		p2.closeConnection();
//		System.out.println("QUEUE2 OK.");
//
//		QUEUE_NAME = "ConsumeQueue3";
//		TibcoProducer p3 = new TibcoProducer();
//		p3.produce(130000, 10240);
//		p3.closeConnection();
//		System.out.println("QUEUE3 OK.");
//
//		QUEUE_NAME = "ConsumeQueue4";
//		TibcoProducer p4 = new TibcoProducer();
//		p4.produce(130000, 32768);
//		p4.closeConnection();
//		System.out.println("QUEUE4 OK.");
//
//		QUEUE_NAME = "ConsumeQueue5";
//		TibcoProducer p5 = new TibcoProducer();
//		p5.produce(130000, 65536);
//		p5.closeConnection();
//		System.out.println("QUEUE5 OK.");
	}
}