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

	public static void generalSend(String topic, int totalMessages) {
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(producerProps(bootstrapServer));
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<String, String>(topic, "key" + counter, "value" + counter));
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

		generalSend(topic, totalMessages);
	}

	public static void massSend() {
		String topic = "kafkaBenchmark2";
		int totalMessages = 100;

		generalSend(topic, totalMessages);
	}

	public static void multipleTopicSingleSend() {
		String topic1 = "kafkaBenchmark3.1";
		String topic2 = "kafkaBenchmark3.2";
		String topic3 = "kafkaBenchmark3.3";

		int totalMessages = 1;

		generalSend(topic1, totalMessages);
		generalSend(topic2, totalMessages);
		generalSend(topic3, totalMessages);
	}

	public static void multipleTopicMassSend() {
		String topic1 = "kafkaBenchmark3.1";
		String topic2 = "kafkaBenchmark3.2";
		String topic3 = "kafkaBenchmark3.3";

		int totalMessages = 100;

		generalSend(topic1, totalMessages);
		generalSend(topic2, totalMessages);
		generalSend(topic3, totalMessages);
	}

}
