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
import com.gocypher.cybench.core.annotation.BenchmarkTag;

@State(Scope.Benchmark)
@BenchmarkMetaData(key = "isLibraryBenchmark", value = "true")
@BenchmarkMetaData(key = "context", value = "Consumer Benchmarks Dan")
@BenchmarkMetaData(key = "domain", value = "java")
@BenchmarkMetaData(key = "version", value = "1.0.0")
@BenchmarkMetaData(key = "description", value = "Testing params of Consumer (512 B)")
public class ConsumerBenchmarks {
	private Consumer myConsumer;
	private ArrayList<String> topics;

	// These are the topic names (named by the byte size of the messages in them)
	@Param({ "512Size" }) // , "1024Size", "10240Size", "32768Size", "65536Size", "1024000Size"
	private String messageSize;

	@Param({ "10000", "100000", "1000000" })
	private int totalConsumedMessages;

	@Setup(Level.Trial)
	public void setup() {
		// Executed before each run of the benchmark
	}

	@Setup(Level.Iteration)
	public void setupIteration() {
		topics = new ArrayList<String>();
		myConsumer = new Consumer();
	}

	@Benchmark
	@BenchmarkTag(tag = "a6af45c6-ca2c-11eb-b8bc-0242ac130003")
	@BenchmarkMetaData(key = "api", value = "middleware-benchmarks")
	@BenchmarkMetaData(key = "libVendor", value = "com.middleware.benchmarks")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/spencerspitz/middleware-benchmarks")
	@BenchmarkMetaData(key = "libVersion", value = "1.0.1")
	@BenchmarkMetaData(key = "libDescription", value = "Benchmarks for Kafka MQ")
	@BenchmarkMetaData(key = "actionName", value = "read")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.middleware.benchmarks")
	@BenchmarkMetaData(key = "libDescription", value = "Just testing benchmark annotations.")
	@BenchmarkMetaData(key = "title", value = "Consuming Kafka Messages")
	@BenchmarkMetaData(key="dataSize", value="512")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 1, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Warmup(iterations = 0, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void consume(Blackhole bh) {
		// Consume topics, total expected messages
		topics.add(messageSize);
		myConsumer.receive(topics, totalConsumedMessages);
	}

	@TearDown(Level.Trial)
	public void tearDown() {
	}

	@TearDown(Level.Iteration)
	public void tearDownIteration() {
		myConsumer.closeConsumer();
	}

}