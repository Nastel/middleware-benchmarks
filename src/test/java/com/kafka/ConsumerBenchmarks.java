
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
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class ConsumerBenchmarks {
	private Consumer myConsumer;
	ArrayList<String> topics;

	@Setup(Level.Trial)
	public void setup() {
		// Executed before each run of the benchmark
		topics = new ArrayList<String>();

		// ADD TOPICS HERE
		topics.add("topicName");
	}

	@Setup(Level.Iteration)
	public void setupIteration() {
		myConsumer = new Consumer();
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 1, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Warmup(iterations = 0, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void receiveBenchmark(Blackhole bh) {
		myConsumer.receiveBenchmark(topics, 10000);
	}

	@TearDown(Level.Trial)
	public void tearDown() {
	}

	@TearDown(Level.Iteration)
	public void tearDownIteration() {
		myConsumer.closeConsumer();
	}

}
