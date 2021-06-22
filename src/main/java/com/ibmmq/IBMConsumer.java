package com.ibmmq;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class IBMConsumer {

	private static final String HOST = "localhost";
	private static final int PORT = 1414;
	private static final String CHANNEL = "DEV.APP.SVRCONN";
	private static final String QMGR = "QM1";
	private static final String APP_USER = "app";
	private static final String APP_PASSWORD = "passw0rd";
	JMSContext context;
	Destination destination;
	JMSConsumer consumer;

	private void makeContext(String QUEUE_NAME) {
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
			consumer = context.createConsumer(destination);
		} catch (JMSException e) {
			if (e != null) {
				if (e instanceof JMSException) {
					e.printStackTrace();
				}
			}
		}
	}

	public IBMConsumer(String msgSize) {
		String QUEUE_NAME = "DEV." + msgSize;
		makeContext(QUEUE_NAME);
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			BytesMessage message = (BytesMessage) consumer.receive();
		}
	}
	
	public void closeConnection(){
		context.close();	
	}

	public static void main(String[] args) throws Exception {
//		IBMConsumer myConsumer = new IBMConsumer();
//		myConsumer.consume();
	}

}
