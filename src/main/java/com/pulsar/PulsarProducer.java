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

import java.util.Properties;
import java.util.Scanner;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class PulsarProducer {

	final static String PULSAR_URL = "pulsar://localhost:6650";
	final static String TEST_TOPIC = "non-persistent://pulsar/benchmarks/non-persist-concurrent";
	final static String BASE_TOPIC = "non-persistent://pulsar/benchmarks/";

	public static String[] topicList = { "", BASE_TOPIC + "10k", BASE_TOPIC + "1k", BASE_TOPIC + "32k",
			BASE_TOPIC + "512b", BASE_TOPIC + "64k" };

	private Producer<byte[]> pulsarProducer;
	private PulsarClient pulsarClient;

	public PulsarProducer() {
		try {
			this.pulsarClient = PulsarClient.builder().serviceUrl(PULSAR_URL).build();
			this.pulsarProducer = this.pulsarClient.newProducer().topic(TEST_TOPIC).create();
		} catch (PulsarClientException e) {
			e.printStackTrace();
		}

	}

	public PulsarProducer(String topic) {
		try {
			this.pulsarClient = PulsarClient.builder().serviceUrl(PULSAR_URL).build();
			this.pulsarProducer = this.pulsarClient.newProducer().topic(topic).create();
		} catch (PulsarClientException e) {
			e.printStackTrace();
		}
	}

	public void closeProducer() {
		try {
			this.pulsarProducer.close();
		} catch (PulsarClientException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			this.pulsarClient.close();
		} catch (PulsarClientException e) {
			e.printStackTrace();
		}
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] message = new byte[msgSize];
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				this.pulsarProducer.send(message);
				this.pulsarProducer.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws PulsarClientException {
		int size = 0;
		Scanner scnr = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter bm#: ");

		int choice = scnr.nextInt();

		switch (choice) {
		case 1:
			size = 10240;
			break;
		case 2:
			size = 1024;
			break;
		case 3:
			size = 32768;
			break;
		case 4:
			size = 512;
			break;
		case 5:
			size = 65536;
			break;
		}

		PulsarProducer p1 = new PulsarProducer(topicList[choice]);
		p1.produce(130000, size);
		p1.closeProducer();
		p1.closeConnection();

	}

}
