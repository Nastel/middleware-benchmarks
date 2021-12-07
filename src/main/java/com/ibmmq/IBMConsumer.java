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

import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;
import com.ibm.mq.MQTopic;
import com.ibm.mq.constants.CMQC;
import com.ibm.mq.constants.MQConstants;

public class IBMConsumer {

	// IBM CONFIG VARS
	private final String HOST = "localhost";
	private final int PORT = 1414;
	private final String CHANNEL = "DEV.APP.SVRCONN";
	private final String QMGR = "QM1";
	private final String APP_USER = "app";
	private final String APP_PASSWORD = "passw0rd";

	private MQQueue queue = null;
	private MQTopic topic = null;
	private MQQueueManager qMgr;
	private MQMessage message;
	private int openOptions;

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
			openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IBMConsumer() {
		buildConnection();
	}

	public void consume(int messagesToRead, String QUEUE_NAME) {
		try {
			if (queue == null) {
				queue = qMgr.accessQueue(QUEUE_NAME, openOptions);
			}
		} catch (MQException e) {
			e.printStackTrace();
		}

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

	public void concurrentConsumeQueue(String QUEUE_NAME) {
		System.out.println("Started consuming");
		try {
			queue = qMgr.accessQueue(QUEUE_NAME, openOptions);
		} catch (MQException e) {
			e.printStackTrace();
		}
		while (true) {
			message = new MQMessage();
			try {
				queue.get(message);
				message.clearMessage();
			} catch (Exception e) {
				if (e instanceof MQException) {
					MQException mqe = (MQException) e;
					if (mqe.reasonCode == 2033) {
						// System.out.println("No messages to consume!");
					}
				} else {
					e.printStackTrace();
				}

			}
		}
	}

	public void concurrentConsumeTopic(String TOPIC_NAME, String SUBSCRIPTION_NAME) {
		System.out.println("Started consuming");
		try {
			topic = qMgr.accessTopic(null, TOPIC_NAME, CMQC.MQSO_CREATE + CMQC.MQSO_RESUME, null, SUBSCRIPTION_NAME);
		} catch (MQException e) {
			e.printStackTrace();
		}
		while (true) {
			message = new MQMessage();
			try {
				topic.get(message);
				message.clearMessage();
			} catch (Exception e) {
				if (e instanceof MQException) {
					MQException mqe = (MQException) e;
					if (mqe.reasonCode == 2033) {
						// System.out.println("No messages to consume!");
					}
				} else {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String args[]) {
		IBMConsumer myConsumer = new IBMConsumer();
		// myConsumer.concurrentConsumeQueue("DEV.myQueue");
		myConsumer.concurrentConsumeTopic("DEV.BASE.TOPIC", "TEST.SUB");
		myConsumer.closeConnection();
	}

}
