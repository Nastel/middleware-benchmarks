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
package com.pulsar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.ConsumerBuilder;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Messages;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Reader;
import org.apache.pulsar.client.api.ReaderBuilder;
import org.apache.pulsar.client.api.Schema;

public class PulsarConsumer {

	final static String PULSAR_URL = "pulsar://localhost:6650";
	final static String TEST_TOPIC_BASE = "non-persistent://pulsar/benchmarks/";

	private ArrayList<String> topics;

	private PulsarClient pulsarClient;
	private Reader<byte[]> pulsarReader;
	private Consumer<byte[]> pulsarConsumer;

	private ConsumerBuilder<byte[]> pulsarConsumerBuilder;
	private ReaderBuilder<byte[]> pulsarReaderBuilder;

	public PulsarConsumer() {
		try {

			pulsarClient = PulsarClient.builder().serviceUrl(PULSAR_URL).build();
			pulsarConsumerBuilder = pulsarClient.newConsumer();
			pulsarReaderBuilder = pulsarClient.newReader();

		} catch (PulsarClientException e) {
			e.printStackTrace();
		}

	}

	public void consumeReader(int messagesToRead, String topicSuffix) {
		try {
			pulsarReader = pulsarReaderBuilder.topic(TEST_TOPIC_BASE + topicSuffix).startMessageId(MessageId.earliest)
					.create();
		} catch (PulsarClientException e1) {
			e1.printStackTrace();
		}

		for (int c = 0; c < messagesToRead; c++) {
			try {
				pulsarReader.readNext();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			pulsarReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void consumer(int messages, String topic) {
		try {
			pulsarConsumer = pulsarClient.newConsumer().topic(topic).subscriptionName("EXCLUSIVE").subscribe();

		} catch (PulsarClientException e) {
			e.printStackTrace();
		}

		System.out.println("Started Consuming.");

		for (int i = 0; i < messages; i++) {
			try {
				Message msg = pulsarConsumer.receive();
				System.out.println("Message Received.");
				System.out.println("Total size of message: " + msg.size());
				pulsarConsumer.acknowledge(msg);
			} catch (PulsarClientException e) {
				e.printStackTrace();
			}

		}

	}

	public void concurrentConsume(String topic) {
		try {

			pulsarClient = PulsarClient.builder().serviceUrl(PULSAR_URL).build();
			pulsarConsumer = pulsarClient.newConsumer().topic(topic).subscriptionName("EXCLUSIVE").subscribe();

		} catch (PulsarClientException e) {
			e.printStackTrace();
		}

		System.out.println("Started Consuming.");

		while (true) {
			try {
				Message msg = pulsarConsumer.receive();
				System.out.println("Message Received.");
				System.out.println("Total size of message: " + msg.size());
				pulsarConsumer.acknowledge(msg);
			} catch (PulsarClientException e) {
				e.printStackTrace();
			}

		}

	}

	public void closeConsumer() {
		try {
			pulsarReader.close();
			pulsarClient.close();
		} catch (PulsarClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}