package kafkatester;

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

import org.apache.kafka.clients.consumer.ConsumerConfig;
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
		properties.put("group.id", "new-group4S");
		//properties.put("session.timeout.ms", "30000");
		//properties.put("auto.offset.reset", "earliest");
		//properties.put("enable.auto.commit", "false");
		//properties.put("auto.commit.interval.ms", "1000");
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
		
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
					if (((ConsumerRecord) record).value() == "end") {
						kafkaConsumer.close();
					}
					//kafkaConsumer.close(20, TimeUnit.MICROSECONDS);
				}
				}} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				kafkaConsumer.close();
			}
		}}//);
	


