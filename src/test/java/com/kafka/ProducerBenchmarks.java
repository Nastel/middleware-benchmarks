
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
//@BenchmarkMetaData(key = "context", value = "ConcurrentProduce")
//@BenchmarkMetaData(key = "context", value = "NonconcurrentProduce")
@BenchmarkMetaData(key = "domain", value = "java")
public class ProducerBenchmarks {
	private Producer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new Producer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeProducer();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce1(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing persistent 1000 msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce2(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce3(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce4(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce5(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce6(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce7(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce8(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce9(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.12")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "2.8.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, 1ms msg retention time")
//	@BenchmarkMetaData(key = "description", value = "Kafka API Producer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaProduce10(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
