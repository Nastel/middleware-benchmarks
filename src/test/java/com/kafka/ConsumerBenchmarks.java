/*
 * Copyright 2021 JKOOL, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
@BenchmarkMetaData(key = "context", value = "NonconcurrentConsume")
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
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1000msg512b(Blackhole bh) {
		myConsumer.consume(1000, "testTopic1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10000msg512b(Blackhole bh) {
		myConsumer.consume(10000, "testTopic1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1000msg1k(Blackhole bh) {
		myConsumer.consume(1000, "testTopic2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10000msg1k(Blackhole bh) {
		myConsumer.consume(10000, "testTopic2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1000msg10k(Blackhole bh) {
		myConsumer.consume(1000, "testTopic3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10000msg10k(Blackhole bh) {
		myConsumer.consume(10000, "testTopic3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1000msg32k(Blackhole bh) {
		myConsumer.consume(1000, "testTopic4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10000msg32k(Blackhole bh) {
		myConsumer.consume(10000, "testTopic4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume1000msg64k(Blackhole bh) {
		myConsumer.consume(1000, "testTopic5");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Kafka")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://kafka.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Kafka is an open-source distributed event streaming platform used by thousands of companies for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.kafka.kafka_2.13")
	@BenchmarkMetaData(key = "libVersion", value = "3.1.0 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Kafka API Consumer, 1 partition, 1 replication factor, 1 broker, 1 zookeeper, default msg retention (persistent)")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void kafkaConsume10000msg64k(Blackhole bh) {
		myConsumer.consume(10000, "testTopic5");
	}

}
