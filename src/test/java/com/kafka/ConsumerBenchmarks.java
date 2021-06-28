package com.kafka;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
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
//@BenchmarkMetaData(key = "context", value = "SynchronousConsume")
//@BenchmarkMetaData(key = "context", value = "Consume")
@BenchmarkMetaData(key = "domain", value = "java")
public class ConsumerBenchmarks {
	private Consumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new Consumer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConsumer();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume2(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume3(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume4(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume5(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume6(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume7(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume8(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume9(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libVersion", value = "2.8.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10(Blackhole bh) {
		myConsumer.consume(10000);
	}

}