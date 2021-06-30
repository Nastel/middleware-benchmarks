
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
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 100 (512)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce1(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 1000 (512)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce2(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 100 (1024)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce3(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 1000 (1024)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce4(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 100 (10240)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce5(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 1000 (10240)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce6(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 100 (32768)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce7(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 1000 (32768)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce8(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 100 (65536)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce9(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "Produce 1000 (65536)")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisProduce10(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
