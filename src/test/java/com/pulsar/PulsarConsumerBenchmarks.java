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
package com.pulsar;

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
public class PulsarConsumerBenchmarks {
	private PulsarConsumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new PulsarConsumer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConsumer();

	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS) // 11,000 per, 55,000 over
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume1000msg512b(Blackhole bh) {
		myConsumer.consumeReader(1000, "512b");

	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS) // 110,000 per, 550,000 over
	public void pulsarConsume10000msg512b(Blackhole bh) {
		myConsumer.consumeReader(10000, "512b");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume1000msg1k(Blackhole bh) {
		myConsumer.consumeReader(1000, "1k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume10000msg1k(Blackhole bh) {
		myConsumer.consumeReader(10000, "1k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume1000msg10k(Blackhole bh) {
		myConsumer.consumeReader(1000, "10k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume10000msg10k(Blackhole bh) {
		myConsumer.consumeReader(10000, "10k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume1000msg32k(Blackhole bh) {
		myConsumer.consumeReader(1000, "32k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume10000msg32k(Blackhole bh) {
		myConsumer.consumeReader(10000, "32k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume1000msg64k(Blackhole bh) {
		myConsumer.consumeReader(1000, "64k");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Pulsar")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://pulsar.apache.org/")
	@BenchmarkMetaData(key = "libDescription", value = "Apache Pulsar is a cloud-native, distributed messaging and streaming platform originally created at Yahoo! and now a top-level Apache Software Foundation project.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.pulsar.pulsar-client")
	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "2.9.1 Persistent")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-P")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "Pulsar API Consumer, basic receive(), 1 broker (standalone), 1 zookeeper, no msg ack, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void pulsarConsume10000msg64k(Blackhole bh) {
		myConsumer.consumeReader(10000, "64k");
	}

}