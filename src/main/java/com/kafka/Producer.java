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

	// Create Message of Size (msgSize)
	public String createMessage(int msgSize) {
		StringBuilder mySB = new StringBuilder(msgSize);
		for (int counter = 0; counter < msgSize; counter++) {
			mySB.append('m');
		}
		return mySB.toString();
	}

	// Sending Messages
	public void generalSend(String topic, int totalMessages, String message) {
		try {
			for (int counter = 0; counter < totalMessages; counter++) {
				kafkaProducer.send(new ProducerRecord<String, String>(topic, "key" + counter, message));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void singleSend() {
		// single small message
		String topic = "trial1";
		int totalMessages = 1;
		String message = createMessage(1);

		generalSend(topic, totalMessages, message);
	}

	public void massSend() {
		// mass small messages
		String topic = "trial2";
		int totalMessages = 100;
		String message = createMessage(1);

		generalSend(topic, totalMessages, message);
	}

	public void multipleTopicSingleSend() {
		// multiple topics, single small message
		String topic1 = "trial3.1";
		String topic2 = "trial3.2";
		String topic3 = "trial3.3";

		int totalMessages = 1;
		String message = createMessage(1);

		generalSend(topic1, totalMessages, message);
		generalSend(topic2, totalMessages, message);
		generalSend(topic3, totalMessages, message);
	}

	public void multipleTopicMassSend() {
		// multiple topics, mass small messages
		String topic1 = "trial4.1";
		String topic2 = "trial4.2";
		String topic3 = "trial4.3";

		int totalMessages = 100;
		String message = createMessage(1);

		generalSend(topic1, totalMessages, message);
		generalSend(topic2, totalMessages, message);
		generalSend(topic3, totalMessages, message);
	}

	public void singleLargeSend() {
		// single large message
		String topic = "trial5";
		int totalMessages = 1;
		String message = createMessage(100);

		generalSend(topic, totalMessages, message);
	}

	public void massLargeSend() {
		// mass large messages
		String topic = "trial6";
		int totalMessages = 100;
		String message = createMessage(100);

		generalSend(topic, totalMessages, message);
	}

	public void multipleTopicSingleLargeSend() {
		// multiple topics, single large message
		String topic1 = "trial7.1";
		String topic2 = "trial7.2";
		String topic3 = "trial7.3";

		int totalMessages = 1;
		String message = createMessage(100);

		generalSend(topic1, totalMessages, message);
		generalSend(topic2, totalMessages, message);
		generalSend(topic3, totalMessages, message);
	}

	public void multipleTopicMassLargeSend() {
		// multiple topics, mass large messages
		String topic1 = "trial8.1";
		String topic2 = "trial8.2";
		String topic3 = "trial8.3";

		int totalMessages = 100;
		String message = createMessage(100);

		generalSend(topic1, totalMessages, message);
		generalSend(topic2, totalMessages, message);
		generalSend(topic3, totalMessages, message);
	}

}
