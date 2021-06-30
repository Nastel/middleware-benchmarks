package com.ibmmq;

import java.util.Hashtable;

import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class IBMConsumer {

	private final String QUEUE_NAME = "DEV.myQueue";
	private static final String HOST = "localhost";
	private static final int PORT = 1414;
	private static final String CHANNEL = "DEV.APP.SVRCONN";
	private static final String QMGR = "QM1";
	private static final String APP_USER = "app";
	private static final String APP_PASSWORD = "passw0rd";

	private MQQueue queue;
	private MQQueueManager qMgr;
	private MQMessage message;
	// private MQGetMessageOptions gmo;

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
			// gmo = new MQGetMessageOptions();
			// gmo.options = MQConstants.MQGMO_NO_WAIT;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IBMConsumer() {
		buildConnection();
	}

	public void consume(int messagesToRead) {
		for (int counter = 0; counter < messagesToRead; counter++) {
			message = new MQMessage();
			try {
				queue.get(message);
				message.clearMessage();
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

	public static void main(String args[]) {
		IBMConsumer myConsumer = new IBMConsumer();
		myConsumer.synchronousConsume();
		myConsumer.closeConnection();
	}

	public void synchronousConsume() {
		System.out.println("Started consuming");
		while (true) {
			message = new MQMessage();
			try {
				queue.get(message);
				message.clearMessage();
			} catch (Exception e) {
				if (e instanceof MQException) {
					MQException mqe = (MQException) e;
					if (mqe.reasonCode == 2033) {
						// System.out.println("no messages to consume");
						// break;
					}
				} else {
					e.printStackTrace();
				}

			}
		}
	}

}
