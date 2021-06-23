
package com.kafka;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import com.gocypher.cybench.core.annotation.BenchmarkMetaData;

@State(Scope.Benchmark)
@BenchmarkMetaData(key = "isLibraryBenchmark", value = "true")
@BenchmarkMetaData(key = "context", value = "Produce")
@BenchmarkMetaData(key = "domain", value = "java")
@BenchmarkMetaData(key = "version", value = "1.0.0")
@BenchmarkMetaData(key = "description", value = "Middleware helps to deliver and track messages between systems")
public class ProducerBenchmarks {
	private Producer myProducer;
	private ArrayList<String> topics;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new Producer();
		topics = new ArrayList<String>();
		topics.add("myTopic");
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeProducer();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce1(Blackhole bh) {
		myProducer.send(topics, 100, 512);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce2(Blackhole bh) {
		myProducer.send(topics, 1000, 512);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce3(Blackhole bh) {
		myProducer.send(topics, 100, 1024);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce4(Blackhole bh) {
		myProducer.send(topics, 1000, 1024);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce5(Blackhole bh) {
		myProducer.send(topics, 100, 10240);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce6(Blackhole bh) {
		myProducer.send(topics, 1000, 10240);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce7(Blackhole bh) {
		myProducer.send(topics, 100, 32768);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce8(Blackhole bh) {
		myProducer.send(topics, 1000, 32768);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce9(Blackhole bh) {
		myProducer.send(topics, 100, 65536);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key="description", value="Produced 100 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce10(Blackhole bh) {
		myProducer.send(topics, 1000, 65536);
	}




}
