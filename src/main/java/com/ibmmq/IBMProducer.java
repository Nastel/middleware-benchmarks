package com.ibmmq;

import java.util.Hashtable;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.constants.MQConstants;
import com.kafka.Producer;

public class IBMProducer {

	// PARAMS
	private boolean persistence = false;

	private String QUEUE_NAME = "DEV.myQueue";
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
		} else {
			message.persistence = MQConstants.MQPER_NOT_PERSISTENT;
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

	public static void main(String args[]) {
		// populates topic for the consumer benchmarks
		IBMProducer p1 = new IBMProducer();
		p1.QUEUE_NAME = "DEV.myQueue1";
		p1.produce(130000, 512);
		p1.closeConnection();

		IBMProducer p2 = new IBMProducer();
		p2.QUEUE_NAME = "DEV.myQueue2";
		p2.produce(130000, 1024);
		p2.closeConnection();

		IBMProducer p3 = new IBMProducer();
		p3.QUEUE_NAME = "DEV.myQueue3";
		p3.produce(130000, 10240);
		p3.closeConnection();

		IBMProducer p4 = new IBMProducer();
		p4.QUEUE_NAME = "DEV.myQueue4";
		p4.produce(130000, 32768);
		p4.closeConnection();

		IBMProducer p5 = new IBMProducer();
		p5.QUEUE_NAME = "DEV.myQueue5";
		p5.produce(130000, 65536);
		p5.closeConnection();
	}

}
