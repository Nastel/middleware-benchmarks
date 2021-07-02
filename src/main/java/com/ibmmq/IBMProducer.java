package com.ibmmq;

import java.util.Hashtable;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;

public class IBMProducer {

	// PARAMS
	private boolean persistence = false;

	private final String QUEUE_NAME = "DEV.myQueue";
	private final String HOST = "localhost";
	private final int PORT = 1414;
	private final String CHANNEL = "DEV.APP.SVRCONN";
	private final String QMGR = "QM1";
	private final String APP_USER = "app";
	private final String APP_PASSWORD = "passw0rd";

	private MQQueue queue;
	private MQQueueManager qMgr;
	private MQPutMessageOptions pmo;

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
			int openOptions = MQConstants.MQOO_OUTPUT;
			queue = qMgr.accessQueue(QUEUE_NAME, openOptions);
			pmo = new MQPutMessageOptions();
			pmo.options = MQConstants.MQPMO_ASYNC_RESPONSE;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IBMProducer() {
		buildConnection();
	}

	public void produce(int totalMessages, int msgSize) {
		MQMessage message = new MQMessage();
		if (persistence) {
			message.persistence = MQConstants.MQPER_PERSISTENT;
		}

		try {
			message.write(msgSize);

			for (int counter = 0; counter < totalMessages; counter++) {
				queue.put(message, pmo);
			}

		} catch (Exception e) {
			e.printStackTrace();
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

}
