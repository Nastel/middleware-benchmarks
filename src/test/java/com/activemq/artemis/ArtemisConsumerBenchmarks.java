
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
@BenchmarkMetaData(key = "context", value = "SynchronousConsume")
@BenchmarkMetaData(key = "domain", value = "java")
public class ArtemisConsumerBenchmarks {
	private ArtemisConsumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new ArtemisConsumer(); 
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume1(Blackhole bh) {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume2(Blackhole bh) {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume3(Blackhole bh) {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume4(Blackhole bh) {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume5(Blackhole bh) {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume6(Blackhole bh) {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume7(Blackhole bh) {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume8(Blackhole bh) {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume9(Blackhole bh) {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Artemis")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/artemis/")
	@BenchmarkMetaData(key = "libVersion", value = "2.17.0")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.artemis-core-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void artemisConsume10(Blackhole bh) {
		myConsumer.consume(10000);
	}


}
