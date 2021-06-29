package com.ibmmq;

import java.util.Hashtable;

import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;

public class IBMConsumer {

	private final String QUEUE_NAME = "DEV.testput";
	private static final String HOST = "localhost";
	private static final int PORT = 1414;
	private static final String CHANNEL = "DEV.APP.SVRCONN";
	private static final String QMGR = "QM1";
	private static final String APP_USER = "app";
	private static final String APP_PASSWORD = "passw0rd";

	private MQQueue queue;
	private MQQueueManager qMgr;
	private MQGetMessageOptions gmo;

	private JMSContext context;
	private Destination destination;
	private JMSConsumer consumer;

	private void buildConnection() {
		Hashtable<String, Object> props = new Hashtable<String, Object>();
		props.put(MQConstants.HOST_NAME_PROPERTY, HOST);
		props.put(MQConstants.PORT_PROPERTY, PORT);
		props.put(MQConstants.CHANNEL_PROPERTY, CHANNEL);
		props.put(MQConstants.USER_ID_PROPERTY, APP_USER);
		props.put(MQConstants.PASSWORD_PROPERTY, APP_PASSWORD);
		props.put(MQConstants.USE_MQCSP_AUTHENTICATION_PROPERTY, true);

		try {
			qMgr = new MQQueueManager(QMGR, props);
			int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF;
			queue = qMgr.accessQueue(QUEUE_NAME, openOptions);
			gmo = new MQGetMessageOptions();
			gmo.options = MQConstants.MQGMO_NO_WAIT;
		} catch (Exception e) {
			System.out.println("error putting");
			e.printStackTrace();
		}
	}

	public IBMConsumer() {
		buildConnection();
	}

	public void consume(int messagesToRead) {
		MQMessage message = new MQMessage();
		for (int counter = 0; counter < messagesToRead; counter++) {
			try {
				queue.get(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			queue.close();
			qMgr.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// FOR SYNCRHONOUS CONSUMPTION

	public static void main(String args[]) {
		IBMConsumer myConsumer = new IBMConsumer(true);
		myConsumer.synchronousConsume();
		myConsumer.closeSyncConnection();
	}

	public void synchronousConsume() {
		while (true) {
			BytesMessage message = (BytesMessage) consumer.receive();
			System.out.println("Message received");
		}
	}

	public IBMConsumer(boolean synchronous) {
		buildSyncConnection();
	}

	private void buildSyncConnection() {
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

	public void closeSyncConnection() {
		context.close();
	}

}
