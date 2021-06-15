package com.ibmmq;

import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class IBMConsumer {

	private static int status = 1;

	private static final String HOST = "localhost";
	private static final int PORT = 1414;
	private static final String CHANNEL = "DEV.APP.SVRCONN";
	private static final String QMGR = "QM1";
	private static final String APP_USER = "app";
	private static final String APP_PASSWORD = "passw0rd";
	private static final String QUEUE_NAME = "Test.ConsumerQueue";
	private static final String QUEUE_NAME2 = "DEV.Test";
	JMSContext context;
	Destination destination, destination2;
	JMSConsumer consumer;

	public static void main(String[] args) throws Exception {
		IBMConsumer myConsumer = new IBMConsumer();
		myConsumer.consume();
	}

	private JMSContext makeContext() throws Exception {
		JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
		JmsConnectionFactory cf = ff.createConnectionFactory();

		cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, HOST);
		cf.setIntProperty(WMQConstants.WMQ_PORT, PORT);
		cf.setStringProperty(WMQConstants.WMQ_CHANNEL, CHANNEL);
		cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
		cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, QMGR);
		cf.setStringProperty(WMQConstants.WMQ_APPLICATIONNAME, "Message Tester (JMS)");
		cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
		cf.setStringProperty(WMQConstants.USERID, APP_USER);
		cf.setStringProperty(WMQConstants.PASSWORD, APP_PASSWORD);
		context = cf.createContext();
		return context;

	}

	public IBMConsumer() throws Exception {
		context = makeContext();
		destination = context.createQueue("queue:///" + QUEUE_NAME2);
		consumer = context.createConsumer(destination);

	}

	public void consume() {
		for (int counter = 0; counter < 10; counter++) {
			consumer.receiveBody(String.class, 15000);
			;
			// consumer.receive(destination2, "HELLO SECOND WORLD!");
			// System.out.println("Message sent to queue");
			recordSuccess();
		}
	}

	private static void recordSuccess() {
		System.out.println("SUCCESS");
		return;
	}

}
