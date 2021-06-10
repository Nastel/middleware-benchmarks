
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

@State(Scope.Benchmark)
public class ProducerBenchmarks {
	private Producer myProducer;
	private ArrayList<String> topics;

	@Param({ "100", "1000" })
	private int totalProducedMessages;

	@Param({ "512", "1024", "10240", "32768", "65536", "1024000" })
	private int messageByteSize;

	@Setup(Level.Trial)
	public void setup() {
		// Executed before each run of the benchmark
		myProducer = new Producer();
		topics = new ArrayList<String>();

		// ADD TOPICS HERE
		topics.add("myTopic");
	}

	@Setup(Level.Iteration)
	public void setupIteration() {
		// Executed before each iteration of the benchmark.
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void produce(Blackhole bh) {
		// Send topics, totalMessages, and messageSize in bytes
		myProducer.send(topics, totalProducedMessages, messageByteSize);
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		// Executed after each run of the benchmark
		myProducer.closeProducer();
	}

	@TearDown(Level.Iteration)
	public void tearDownIteration() {
		// Executed after each iteration of the benchmark.
	}

}
