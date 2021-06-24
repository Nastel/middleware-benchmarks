package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
	private final String topic = "myTopic";
	private final String bootstrapServer = "localhost:9092";
	private KafkaProducer<Integer, byte[]> kafkaProducer;

	private Properties producerProps() {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", bootstrapServer);
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

		return props;
	}

	public Producer() {
		kafkaProducer = new KafkaProducer<Integer, byte[]>(producerProps());
	}

	public void closeProducer() {
		kafkaProducer.close();
	}

	public void produce(int totalMessages, int msgSize) {
		byte[] message = new byte[msgSize];

		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<Integer, byte[]>(topic, counter, message));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
