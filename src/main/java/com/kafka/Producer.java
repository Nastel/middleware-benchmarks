package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
	// Globals
	final static String bootstrapServer = "localhost:9092";

	public static void main(String args[]) {
		// Producer.basicSend();
	}

	private static Properties producerProps(String bootstrapServer) {
		String serializer = StringSerializer.class.getName();
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

		return props;
	}

	public static void generalSend(String topic, int totalMessages, String[] keys, String[] values) {
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(producerProps(bootstrapServer));
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<String, String>(topic, keys[counter], values[counter]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			kafkaProducer.close();
		}
	}

	public static void singleSend() {
		String topic = "kafkaBenchmark1";
		int totalMessages = 1;
		String[] keys = { "key" };
		String[] values = { "value" };

		generalSend(topic, totalMessages, keys, values);
	}

	public static void massSend() {
		String topic = "kafkaBenchmark2";
		int totalMessages = 100;
		String[] keys = new String[100];
		String[] values = new String[100];

		for (int counter = 0; counter < totalMessages; counter++) {
			keys[counter] = "key" + counter;
			values[counter] = "value" + counter;
		}

		generalSend(topic, totalMessages, keys, values);
	}

}
