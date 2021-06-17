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
	private Connection mConnection;
	private Session mSession;
	private MessageConsumer mConsumer;

	public void buildConnection(String QUEUE_NAME) {
		try {
			TransportConfiguration transportConfiguration = new TransportConfiguration(
					NettyConnectorFactory.class.getName());
			ConnectionFactory cf = ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,
					transportConfiguration);
			mConnection = cf.createConnection();
			mSession = mConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue mQueue = mSession.createQueue(QUEUE_NAME);
			mConsumer = mSession.createConsumer(mQueue);
			mConnection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ArtemisConsumer(String msgSize) {
		String QUEUE_NAME = "Queue." + msgSize;
		buildConnection(QUEUE_NAME);
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				BytesMessage message = (BytesMessage) mConsumer.receive();
				System.out.println("Received message " + counter + " of " + messagesToRead);
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

	public static void main(String[] args) {
	}

}
