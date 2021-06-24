package com.kafka;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
	// Globals
	private final String bootstrapServer = "localhost:9092";
	private KafkaProducer<String, byte[]> kafkaProducer;
	private ArrayList<String> topics;
	private int totalMessages, messageSize;
	private byte[] message;

	// Constructing and Creating Producer
	private Properties producerProps() {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", bootstrapServer);
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

		return props;
	}

	public Producer() {
		kafkaProducer = new KafkaProducer<String, byte[]>(producerProps());
		topics = new ArrayList<String>();
	}

	// Closing Producer
	public void closeProducer() {
		kafkaProducer.close();
	}

	// Produce Method
	public void produce(String topic) {
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<String, byte[]>(topic, counter + "", message));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Benchmark
	// msgSize is amount of bytes
	public void send(ArrayList<String> topicsToAdd, int totalMsgs, int msgSize) {
		totalMessages = totalMsgs;
		messageSize = msgSize;
		message = new byte[msgSize];

		for (String topic : topicsToAdd) {
			topics.add(topic);
			produce(topic);
		}
	}
}
