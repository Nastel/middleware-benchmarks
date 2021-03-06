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

package com.kafka;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
	private ArrayList<String> topics;
	private final String bootstrapServer = "localhost:9092";
	private KafkaConsumer<Integer, byte[]> kafkaConsumer;
	private int totalReadMessages;

	private Properties consumerProps() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", bootstrapServer);
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
		properties.put("group.id", "new-group");
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
		properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);

		return properties;
	}

	public Consumer() {
		kafkaConsumer = new KafkaConsumer<>(consumerProps());
		topics = new ArrayList<String>();
	}

	public void closeConsumer() {
		kafkaConsumer.close();
	}

	public void consume(int messagesToRead, String TOPIC_NAME) {
		if (topics.isEmpty()) {
			topics.add(TOPIC_NAME);
			kafkaConsumer.subscribe(topics);
		}
		totalReadMessages = 0;

		try {
			listeningLoop: while (true) {
				ConsumerRecords<Integer, byte[]> records = kafkaConsumer.poll(100);
				for (ConsumerRecord<Integer, byte[]> record : records) {
					byte[] message = record.value();
					totalReadMessages++;
					if (totalReadMessages >= messagesToRead) {
						break listeningLoop;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void concurrentConsume() {
		topics.add("myTopic");
		kafkaConsumer.subscribe(topics);
		System.out.println("Started consuming");

		try {
			while (true) {
				ConsumerRecords<Integer, byte[]> records = kafkaConsumer.poll(100);
				for (ConsumerRecord<Integer, byte[]> record : records) {
					byte[] message = record.value();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Consumer myConsumer = new Consumer();
		myConsumer.concurrentConsume();
		myConsumer.closeConsumer();
	}
}
