package com.ibmmq;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class Producer {
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
	JMSProducer producer;
	
	public static void main(String[] args) throws Exception {
    	Producer myProducer = new Producer();
    	myProducer.produce();
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
	
	public Producer() throws Exception {
		context = makeContext();
		destination = context.createQueue("queue:///" + QUEUE_NAME2);
		destination2 = context.createQueue("queue:///" + QUEUE_NAME);
		producer = context.createProducer();

	
	}
	
	public void produce() {
		for (int counter = 0; counter < 10; counter++) {
			producer.send(destination, "HELLO WORLD!");
			producer.send(destination2, "HELLO SECOND WORLD!");
			System.out.println("Message sent to queue");
			recordSuccess();
		}
	}		
	
	private static void recordSuccess() {
		System.out.println("SUCCESS");
		status = 0;
		return;
	}

}
