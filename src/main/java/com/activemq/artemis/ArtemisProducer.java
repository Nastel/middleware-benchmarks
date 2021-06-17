package com.activemq.artemis;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

public class ArtemisProducer {
	private final String QUEUE_NAME = "Test.Benchmark"; // set queue name
	private Connection mConnection;
	private Session mSession;
	private MessageProducer mProducer;

	public void buildConnection() {
		try {
			TransportConfiguration transportConfiguration = new TransportConfiguration(
					NettyConnectorFactory.class.getName());
			ConnectionFactory cf = ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,
					transportConfiguration);
			mConnection = cf.createConnection();
			mSession = mConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue mQueue = mSession.createQueue(QUEUE_NAME);
			mProducer = mSession.createProducer(mQueue);
			mConnection.start();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public ArtemisProducer() {
		buildConnection();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] byteArrMsg = new byte[msgSize];
		try {
			BytesMessage message = mSession.createBytesMessage();
			message.writeBytes(byteArrMsg);

			for (int counter = 0; counter < totalMessages; counter++) {
				mProducer.send(message);
				System.out.println("Message " + counter + " sent to queue");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			mConnection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws JMSException {
	}
}
