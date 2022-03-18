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
package com.tibco;

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
import com.tibco.TibcoConsumer;

@State(Scope.Benchmark)
@BenchmarkMetaData(key = "isLibraryBenchmark", value = "true")
@BenchmarkMetaData(key = "context", value = "NonconcurrentConsume")
@BenchmarkMetaData(key = "domain", value = "java")
public class TibcoConsumerBenchmarks {
	private TibcoConsumer myConsumer;
	

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new TibcoConsumer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume1000msg512b(Blackhole bh) {
		myConsumer.consume(1000, "ConsumeQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 512 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume10000msg512b(Blackhole bh) {
		myConsumer.consume(10000, "ConsumeQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume1000msg1k(Blackhole bh) {
		myConsumer.consume(1000, "ConsumeQueue2");
	}
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 1024 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume10000msg1k(Blackhole bh) {
		myConsumer.consume(10000, "ConsumeQueue2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume1000msg10k(Blackhole bh) {
		myConsumer.consume(1000, "ConsumeQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 10240 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume10000msg10k(Blackhole bh) {
		myConsumer.consume(10000, "ConsumeQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume1000msg32k(Blackhole bh) {
		myConsumer.consume(1000, "ConsumeQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 32768 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume10000msg32k(Blackhole bh) {
		myConsumer.consume(10000, "ConsumeQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume1000msg64k(Blackhole bh) {
		myConsumer.consume(1000, "ConsumeQueue5");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "Tibco EMS")
	@BenchmarkMetaData(key = "libVendor", value = "Tibco")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.tibco.com/products/tibco-enterprise-message-service")
	@BenchmarkMetaData(key = "libDescription", value = "Enterprise-grade messaging for mission-critical applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.tibco.tibjms")
//	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 NonPersistent")
	@BenchmarkMetaData(key = "libVersion", value = "10.1.0 Persistent")	
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-NonP")
	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 65536 bytes")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMetaData(key = "description", value = "JMS Consumer, Tibco JMS Connection, msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void tibcoConsume10000msg64k(Blackhole bh) {
		myConsumer.consume(10000, "ConsumeQueue5");
	}

}
