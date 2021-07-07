package com.activemq.artemis;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

public class ArtemisProducer {
	// PARAMS
	private boolean persistence = false;
	
	private static String QUEUE_NAME = "MyQueue";
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
			
			if(persistence){
				mProducer.setDeliveryMode(DeliveryMode.PERSISTENT);	
			}
			else{
				mProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);	
			}
			
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

	public static void main(String[] args) {
		// populates topic for the consumer benchmarks
		QUEUE_NAME = "MyQueue1";
		ArtemisProducer p1 = new ArtemisProducer();
		p1.produce(130000, 512);
		p1.closeConnection();

		QUEUE_NAME = "MyQueue2";
		ArtemisProducer p2 = new ArtemisProducer();
		p2.produce(130000, 1024);
		p2.closeConnection();

		QUEUE_NAME = "MyQueue3";
		ArtemisProducer p3 = new ArtemisProducer();
		p3.produce(130000, 10240);
		p3.closeConnection();

		QUEUE_NAME = "MyQueue4";
		ArtemisProducer p4 = new ArtemisProducer();
		p4.produce(130000, 32768);
		p4.closeConnection();

		QUEUE_NAME = "MyQueue5";
		ArtemisProducer p5 = new ArtemisProducer();
		p5.produce(130000, 65536);
		p5.closeConnection();
	}
}
