package com.kafka;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {
	// Globals
	private final String bootstrapServer = "localhost:9092";
	private KafkaConsumer<String, byte[]> kafkaConsumer;
	private int totalReadMessages;

	private Properties consumerProps() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", bootstrapServer);
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
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
	}

	public void closeConsumer() {
		System.out.println("\nClosing consumer...\n" + "Total read messages: " + totalReadMessages);
		kafkaConsumer.close();
	}

	public void receive(ArrayList<String> topics, int messagesToRead) {
		kafkaConsumer.subscribe(topics);
		totalReadMessages = 0;

		try {
			listeningLoop: while (true) {
				ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(100);
				for (ConsumerRecord<String, byte[]> record : records) {
					String message = "Msg size: " + record.value().length;
					System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), message);
					totalReadMessages++;
					if (totalReadMessages == messagesToRead) {
						break listeningLoop;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
