package com.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

	public static void main(String[] args) {
		Consumer.receive();
	}
	public static void receive() {
		
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "localhost:9092"); // Change IP depending on producer 11.0.0.173
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		properties.put("group.id", "test-group");
		properties.put("session.timeout.ms", "10000");
		properties.put("auto.offset.reset", "earliest");

		KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
		List topics = new ArrayList();
		topics.add("newKafkaTest"); // Change Topic depending on producer consumeTrial1
		kafkaConsumer.subscribe(topics);
		//CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		//ExecutorService service = Executors.newFixedThreadPool(5);
		//Future<Integer> future = service.submit(new Task());
			try {
				while(true) {
				ConsumerRecords records = kafkaConsumer.poll(10);
				for (Object record : records) {
					System.out.println(
							String.format("Topic - %s, Partition - %d, Value: %s", ((ConsumerRecord) record).topic(),
									((ConsumerRecord) record).partition(), ((ConsumerRecord) record).value()));
					//kafkaConsumer.close(20, TimeUnit.MICROSECONDS);
				}
				}} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				kafkaConsumer.close();
			}
		}}//);
	


