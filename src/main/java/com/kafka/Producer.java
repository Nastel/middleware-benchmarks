package com.kafka;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
	// Globals
	private final String bootstrapServer = "localhost:9092";
	private KafkaProducer<String, String> kafkaProducer;
	private ArrayList<String> topics;
	private int totalMessages;
	private String message;

	// Constructing and Creating Producer
	private Properties producerProps() {
		String serializer = StringSerializer.class.getName();
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

		return props;
	}

	public Producer() {
		kafkaProducer = new KafkaProducer<String, String>(producerProps());
	}

	// Closing Producer
	public void closeProducer() {
		message = "end";
		for (String topic : topics) {
			send(topic);
		}
		kafkaProducer.close();
	}

	// Create Message of Size (msgSize)
	private String createMessage(int msgSize) {
		StringBuilder mySB = new StringBuilder(msgSize);
		for (int counter = 0; counter < msgSize; counter++) {
			mySB.append('m');
		}
		return mySB.toString();
	}

	// Send Method
	public void send(String topic) {
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<String, String>(topic, "key" + counter, message));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Specific Benchmarks
	public void sendBenchmark(ArrayList<String> topicsToAdd, int totalMsgs, int msgSize) {
		totalMessages = totalMsgs;
		message = createMessage(msgSize);

		for (String topic : topicsToAdd) {
			topics.add(topic);
			send(topic);
		}
	}

}
