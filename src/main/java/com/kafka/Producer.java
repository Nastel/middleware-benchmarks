package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer {
	// Globals
	final String bootstrapServer = "localhost:9092";
	KafkaProducer<String, String> kafkaProducer;

	// Constructing and Creating Producer
	private static Properties producerProps(String bootstrapServer) {
		String serializer = StringSerializer.class.getName();
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

		return props;
	}

	public Producer() {
		kafkaProducer = new KafkaProducer<String, String>(producerProps(bootstrapServer));
	}

	// Closing Producer
	public void closeProducer() {
		kafkaProducer.close();
	}

	// Sending Messages
	public void generalSend(String topic, int totalMessages, boolean largeMsg) {
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				if (largeMsg) {

				} else {
					kafkaProducer.send(new ProducerRecord<String, String>(topic, "key" + counter, "value" + counter));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void singleSend() {
		// single small message
		String topic = "kafkaBenchmark1";
		int totalMessages = 1;

		generalSend(topic, totalMessages, false);
	}

	public void massSend() {
		// mass small messages
		String topic = "kafkaBenchmark2";
		int totalMessages = 100;

		generalSend(topic, totalMessages, false);
	}

	public void multipleTopicSingleSend() {
		// multiple topics, single small messages
		String topic1 = "kafkaBenchmark3.1";
		String topic2 = "kafkaBenchmark3.2";
		String topic3 = "kafkaBenchmark3.3";

		int totalMessages = 1;

		generalSend(topic1, totalMessages, false);
		generalSend(topic2, totalMessages, false);
		generalSend(topic3, totalMessages, false);
	}

	public void multipleTopicMassSend() {
		// multiple topics, mass small messages
		String topic1 = "kafkaBenchmark3.1";
		String topic2 = "kafkaBenchmark3.2";
		String topic3 = "kafkaBenchmark3.3";

		int totalMessages = 100;

		generalSend(topic1, totalMessages, false);
		generalSend(topic2, totalMessages, false);
		generalSend(topic3, totalMessages, false);
	}

	public void singleLargeSend() {
		// single large message
		String topic = "kafkaBenchmark4";
		int totalMessages = 1;

		generalSend(topic, totalMessages, true);
	}

}
