package com.activemq.artemis;

import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.QueueConfiguration;
import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.core.client.ActiveMQClient;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.api.core.client.ClientProducer;
import org.apache.activemq.artemis.api.core.client.ClientSession;
import org.apache.activemq.artemis.api.core.client.ClientSessionFactory;
import org.apache.activemq.artemis.api.core.client.ServerLocator;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

public class ArtemisProducer {
	private final String QUEUE_NAME = "TestQueue";
	private ClientSession mySession;
	private ClientMessage myMessage;
	private ClientProducer myProducer;

	public void buildConnection() {
		ServerLocator locator = ActiveMQClient
				.createServerLocatorWithoutHA(new TransportConfiguration(NettyConnectorFactory.class.getName()));
		try {

			ClientSessionFactory factory = locator.createSessionFactory();
			mySession = factory.createSession();
			myMessage = mySession.createMessage(true);
			myProducer = mySession.createProducer(QUEUE_NAME);
			
			// Creates queue if it does not exist
			QueueConfiguration queueConfig = new QueueConfiguration(QUEUE_NAME);
			queueConfig.setDurable(true);
			mySession.createQueue(queueConfig);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArtemisProducer() {
		buildConnection();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] byteMessage = new byte[msgSize];
		myMessage.getBodyBuffer().writeBytes(byteMessage);

		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				myProducer.send(myMessage);
			}
		} catch (ActiveMQException e) {
			e.printStackTrace();
		}
	}

	// Unnecessary to close connection for this producer (only need to "start" a session to consume messages in this case)
	
//	public void closeConnection() {
//		try {
//			mySession.close();
//		} catch (ActiveMQException e) {
//			e.printStackTrace();
//		}
//	}

}
