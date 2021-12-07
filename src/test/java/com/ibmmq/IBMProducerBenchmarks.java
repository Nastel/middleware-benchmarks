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
package com.ibmmq;

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
public class IBMProducerBenchmarks {
	private IBMProducer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new IBMProducer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg512b(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg512b(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg1k(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 non persistent msgs of 1024 bytes")	
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg1k(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg10k(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg10k(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg32k(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg32k(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 100 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 100 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg64k(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.3.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P-Concurrent-StreamQ")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P-Concurrent-Topic-1sub")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing and streaming 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing and streaming 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence, concurrent produce")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg64k(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
