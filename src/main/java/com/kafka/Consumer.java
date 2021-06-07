package com.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

	public static void main(String[] args) {
		Consumer.receive();
	}
	public static void receive() {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092"); // Change IP depending on producer
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id", "test-group");
		
		KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
		List topics = new ArrayList();
		topics.add("newKafkaTest"); // Change Topic depending on producer
		kafkaConsumer.subscribe(topics);
		try {
			while (true) {
				ConsumerRecords records = kafkaConsumer.poll(10);
				for (Object record : records) {
					System.out.println(
							String.format("Topic - %s, Partition - %d, Value: %s", ((ConsumerRecord) record).topic(),
									((ConsumerRecord) record).partition(), ((ConsumerRecord) record).value()));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			kafkaConsumer.close();
		}
	}
}