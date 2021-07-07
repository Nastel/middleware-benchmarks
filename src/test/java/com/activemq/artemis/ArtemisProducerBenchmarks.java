
package com.activemq.artemis;

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
//@BenchmarkMetaData(key = "context", value = "ConcurrentProduce")
//@BenchmarkMetaData(key = "context", value = "NonconcurrentProduce")
@BenchmarkMetaData(key = "domain", value = "java")
public class ArtemisProducerBenchmarks {
	private ArtemisProducer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new ArtemisProducer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce100msg512b(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1000msg512b(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce100msg1k(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1000msg1k(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce100msg10k(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1000msg10k(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce100msg32k(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1000msg32k(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce100msg64k(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 NonPersistent")
// 	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP-Concurrent")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P-Concurrent")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Producing 100 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Concurrently producing 100 persistent msgs of 512 bytes")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, no msg persistence, concurrent produce")
// 	@BenchmarkMetaData(key = "description", value = "JMS Producer, Artemis Core Connection, auto msg acknowledge, paging address full policy, ~512Mb global max size, msg persistence, concurrent produce")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1000msg64k(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
