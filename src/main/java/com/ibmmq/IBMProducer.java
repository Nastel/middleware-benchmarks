/*
 * Copyright 2021 JKOOL, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ibmmq;

import java.util.Hashtable;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.MQTopic;
import com.ibm.mq.constants.CMQC;
import com.ibm.mq.constants.MQConstants;

public class IBMProducer {

	// PARAMS
	private final boolean PERSISTENCE = false;

	// IBM CONFIG VARS
	private static String QUEUE_NAME = "DEV.myQueue";
	private static String TOPIC_NAME = "DEV.BASE.TOPIC";
	private final String HOST = "localhost";
	private final int PORT = 1414;
	private final String CHANNEL = "DEV.APP.SVRCONN";
	private final String QMGR = "QM1";
	private final String APP_USER = "app";
	private final String APP_PASSWORD = "passw0rd";

	private MQQueue queue;
	private MQTopic topic;
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
//			topic = qMgr.accessTopic(null, TOPIC_NAME, CMQC.MQTOPIC_OPEN_AS_PUBLICATION, CMQC.MQOO_OUTPUT);
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
		if (PERSISTENCE) {
			message.persistence = MQConstants.MQPER_PERSISTENT;
		} else {
			message.persistence = MQConstants.MQPER_NOT_PERSISTENT;
		}

		try {
			message.write(msgSize);

			for (int counter = 0; counter < totalMessages; counter++) {
				queue.put(message, pmo);
//				topic.put(message, pmo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			queue.close();
//			topic.close();
			qMgr.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		// populates queues for the consumer benchmarks
		QUEUE_NAME = "DEV.myQueue1";
		IBMProducer p1 = new IBMProducer();
		p1.produce(130000, 512);
		p1.closeConnection();

		QUEUE_NAME = "DEV.myQueue2";
		IBMProducer p2 = new IBMProducer();
		p2.produce(130000, 1024);
		p2.closeConnection();

		QUEUE_NAME = "DEV.myQueue3";
		IBMProducer p3 = new IBMProducer();
		p3.produce(130000, 10240);
		p3.closeConnection();

		QUEUE_NAME = "DEV.myQueue4";
		IBMProducer p4 = new IBMProducer();
		p4.produce(130000, 32768);
		p4.closeConnection();

		QUEUE_NAME = "DEV.myQueue5";
		IBMProducer p5 = new IBMProducer();
		p5.produce(130000, 65536);
		p5.closeConnection();
	}

}
