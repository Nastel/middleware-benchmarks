
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

@State(Scope.Benchmark)
public class ProducerBenchmarks {

	@Setup(Level.Trial)
	public void setup() {
		// TODO Trial level: write code to be executed before each run of the benchmark
	}

	@Setup(Level.Iteration)
	public void setupIteration() {
		// TODO Iteration level: write code to be executed before each iteration of the
		// benchmark.
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
	public void basicSendBenchmark(Blackhole bh) {
		Producer.basicSend();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		// TODO Trial level: write code to be executed after each run of the benchmark
	}

	@TearDown(Level.Iteration)
	public void tearDownIteration() {
		// TODO Iteration level: write code to be executed after each iteration of the
		// benchmark.
	}

}
