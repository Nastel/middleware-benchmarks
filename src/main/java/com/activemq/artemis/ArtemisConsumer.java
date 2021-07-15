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

package com.activemq.artemis;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Queue;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

public class ArtemisConsumer {
	private Queue mQueue = null;
	private Connection mConnection;
	private Session mSession;
	private MessageConsumer mConsumer;

	public void buildConnection() {
		try {
			TransportConfiguration transportConfiguration = new TransportConfiguration(
					NettyConnectorFactory.class.getName());
			ConnectionFactory cf = ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,
					transportConfiguration);
			mConnection = cf.createConnection();
			mSession = mConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ArtemisConsumer() {
		buildConnection();
	}

	public void consume(int messagesToRead, String QUEUE_NAME) {
		if (mQueue == null) {
			try {
				mQueue = mSession.createQueue(QUEUE_NAME);
				mConsumer = mSession.createConsumer(mQueue);
				mConnection.start();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				BytesMessage message = (BytesMessage) mConsumer.receive();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			mConnection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void concurrentConsume(String QUEUE_NAME) {
		System.out.println("Started consuming");

		if (mQueue == null) {
			try {
				mQueue = mSession.createQueue(QUEUE_NAME);
				mConsumer = mSession.createConsumer(mQueue);
				mConnection.start();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

		while (true) {
			try {
				BytesMessage message = (BytesMessage) mConsumer.receive();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ArtemisConsumer myConsumer = new ArtemisConsumer();
		myConsumer.concurrentConsume("MyQueue");
		myConsumer.closeConnection();
	}

}
