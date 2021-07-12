package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
	private String topic = "myTopic";
	private final String bootstrapServer = "localhost:9092";
	private KafkaProducer<Integer, byte[]> kafkaProducer;

	private Properties producerProps() {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", bootstrapServer);
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
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

	public static void main(String args[]) {
		// populates topics for the consumer benchmarks
		Producer p1 = new Producer();
		p1.topic = "myTopic1";
		p1.produce(130000, 512);
		p1.closeProducer();

		Producer p2 = new Producer();
		p2.topic = "myTopic2";
		p2.produce(130000, 1024);
		p2.closeProducer();

		Producer p3 = new Producer();
		p3.topic = "myTopic3";
		p3.produce(130000, 10240);
		p3.closeProducer();

		Producer p4 = new Producer();
		p4.topic = "myTopic4";
		p4.produce(130000, 32768);
		p4.closeProducer();

		Producer p5 = new Producer();
		p5.topic = "myTopic5";
		p5.produce(130000, 65536);
		p5.closeProducer();
	}
}
