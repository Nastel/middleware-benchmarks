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

package com.rabbitmq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Envelope;

public class RabbitConsumer {
	private Connection myConnection;
	private Channel myChannel;
	public static int msgsRead;
	public static String curConsumerTag;

	private void makeConnection() {
		ConnectionFactory myFactory = new ConnectionFactory();
		myFactory.setHost("localhost");

		try {
			myConnection = myFactory.newConnection();
			myChannel = myConnection.createChannel(1);
			myChannel.basicQos(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RabbitConsumer() {
		makeConnection();
	}

	public void consume(int messagesToRead, String QUEUE_NAME) {
		try {
			msgsRead = 0;
			myChannel.basicConsume(QUEUE_NAME, false, new DefaultConsumer(myChannel) {
				public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties props,
						byte[] body) throws IOException {
					myChannel.basicQos(1);

					DeliverCallback deliverCallback = (tmpConsumerTag, delivery) -> {
						long deliveryTag = envelope.getDeliveryTag();

						myChannel.basicAck(deliveryTag, false);
						msgsRead++;

						if (msgsRead >= (messagesToRead)) {
							myChannel.abort();
						}

					};
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			myChannel.close();
			myChannel.abort();
			myConnection.abort();
			myConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void concurrentConsume(String QUEUE_NAME) {
		try {
			myChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				delivery.getBody();
			};
			myChannel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}