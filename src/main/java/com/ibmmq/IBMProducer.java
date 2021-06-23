package com.ibmmq;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class IBMProducer {

	private static final String HOST = "localhost";
	private static final int PORT = 1414;
	private static final String CHANNEL = "DEV.APP.SVRCONN";
	private static final String QMGR = "QM1";
	private static final String APP_USER = "app";
	private static final String APP_PASSWORD = "passw0rd";
	private static final String QUEUE_NAME = "Dev.MyQueue";

	JMSContext context;
	Destination destination, destination2;
	JMSProducer producer;

	private void makeContext() {
		try {
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
			destination = context.createQueue("queue:///" + QUEUE_NAME);
			producer = context.createProducer();
		} catch (JMSException e) {
			if (e != null) {
				if (e instanceof JMSException) {
					e.printStackTrace();
				}
			}
		}
	}

	public IBMProducer() {
		makeContext();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] byteArrMsg = new byte[msgSize];
		BytesMessage message = context.createBytesMessage();
		try {
			message.writeBytes(byteArrMsg);
		} catch (JMSException e) {
			e.printStackTrace();
		}

		for (int counter = 0; counter < totalMessages; counter++) {
			producer.send(destination, message);
			System.out.println("Message " + counter + " sent to queue");
		}
	}
	
	public void closeConnection(){
		context.close();	
	}

	public static void main(String[] args) {
//		IBMProducer myProducer = new IBMProducer();
//		myProducer.produce(1000, 1024);
	}

}
