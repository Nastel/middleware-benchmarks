package com.activemq.artemis;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;

public class ArtemisProducer {

	public static void main(String[] args) throws JMSException {
		TransportConfiguration transportConfiguration = new TransportConfiguration(NettyConnectorFactory.class.getName());

		ConnectionFactory cf = ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,transportConfiguration);

		//We also create the JMS Queue object via the ActiveMQJMSClient Utility
		//class:

		Queue orderQueue = ActiveMQJMSClient.createQueue("OrderQueue");

		//Next we create a JMS connection using the connection factory:

		Connection connection = cf.createConnection();

		//And we create a non transacted JMS Session, with AUTO\_ACKNOWLEDGE
		//acknowledge mode:

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		//We create a MessageProducer that will send orders to the queue:

		MessageProducer producer = session.createProducer(orderQueue);

		//And we create a MessageConsumer which will consume orders from the
		//queue:

		MessageConsumer consumer = session.createConsumer(orderQueue);

		//We make sure we start the connection, or delivery won't occur on it:

		connection.start();

		//We create a simple TextMessage and send it:

		TextMessage message = session.createTextMessage("This is an order");
		producer.send(message);

		//And we consume the message:

		//TextMessage receivedMessage = (TextMessage)consumer.receive();
		//System.out.println("Got order: " + receivedMessage.getText());
	}

}
