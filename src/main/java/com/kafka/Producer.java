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

	// Sending Messages
	private void setParamsAndSend(ArrayList<String> topicsToAdd, int totalMsgs, int msgSize) {
		topics = topicsToAdd;
		totalMessages = totalMsgs;
		message = createMessage(msgSize);

		for (String topic : topics) {
			send(topic);
		}
	}

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
	public void singleSend() {
		// single small message
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial1");

		setParamsAndSend(topicsToAdd, 1, 1);
	}

	public void massSend() {
		// mass small messages
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial2");

		setParamsAndSend(topicsToAdd, 100, 1);
	}

	public void multipleTopicSingleSend() {
		// multiple topics, single small message
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial3.1");
		topicsToAdd.add("consumeTrial3.2");
		topicsToAdd.add("consumeTrial3.3");

		setParamsAndSend(topicsToAdd, 1, 1);
	}

	public void multipleTopicMassSend() {
		// multiple topics, mass small messages
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial4.1");
		topicsToAdd.add("consumeTrial4.2");
		topicsToAdd.add("consumeTrial4.3");

		setParamsAndSend(topicsToAdd, 100, 1);
	}

	public void singleLargeSend() {
		// single large message
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial5");

		setParamsAndSend(topicsToAdd, 1, 100);
	}

	public void massLargeSend() {
		// mass large messages
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial6");

		setParamsAndSend(topicsToAdd, 100, 100);
	}

	public void multipleTopicSingleLargeSend() {
		// multiple topics, single large message
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial7.1");
		topicsToAdd.add("consumeTrial7.2");
		topicsToAdd.add("consumeTrial7.3");

		setParamsAndSend(topicsToAdd, 1, 100);
	}

	public void multipleTopicMassLargeSend() {
		// multiple topics, mass large messages
		ArrayList<String> topicsToAdd = new ArrayList<String>();
		topicsToAdd.add("consumeTrial8.1");
		topicsToAdd.add("consumeTrial8.2");
		topicsToAdd.add("consumeTrial8.3");

		setParamsAndSend(topicsToAdd, 100, 100);
	}

}
