package com.activemq.artemis;

import javax.jms.Message;

import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.QueueConfiguration;
import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.core.client.ActiveMQClient;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.api.core.client.ClientConsumer;
import org.apache.activemq.artemis.api.core.client.ClientSession;
import org.apache.activemq.artemis.api.core.client.ClientSessionFactory;
import org.apache.activemq.artemis.api.core.client.ServerLocator;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

import com.ibmmq.IBMConsumer;

public class ArtemisConsumer {
	private final String QUEUE_NAME = "TestQueue";
	private ClientSession mySession;
	private ClientConsumer myConsumer;

	public void buildConnection() {
		ServerLocator locator = ActiveMQClient
				.createServerLocatorWithoutHA(new TransportConfiguration(NettyConnectorFactory.class.getName()));
		try {

			ClientSessionFactory factory = locator.createSessionFactory();
			mySession = factory.createSession();
			myConsumer = mySession.createConsumer(QUEUE_NAME);
			mySession.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArtemisConsumer() {
		buildConnection();
	}

	public void closeConnection() {
		try {
			mySession.close();
		} catch (ActiveMQException e) {
			e.printStackTrace();
		}
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				ClientMessage message = myConsumer.receive();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void synchronousConsume() {
		while (true) {
			try {
				ClientMessage message = myConsumer.receive();
				System.out.println("Message received");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		ArtemisConsumer myConsumer = new ArtemisConsumer();
		myConsumer.synchronousConsume();
	}

}
