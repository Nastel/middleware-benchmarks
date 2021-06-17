package com.activemq.classic;

import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;

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
@BenchmarkMetaData(key = "context", value = "SendMsg")
@BenchmarkMetaData(key = "domain", value = "java")
@BenchmarkMetaData(key = "version", value = "1.0.0")
@BenchmarkMetaData(key = "description", value = "Middleware helps to deliver and track messages between systems")
public class ActiveMQProducerBenchmarks {
	private ActiveMQProducer myProducer;

	@Param({ "10", "1000" })
	private int totalProducedMessages;

	@Param({ "512", "1024", "10240", "32768", "65536" })
	private int messageByteSize;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new ActiveMQProducer();
	}

	@Setup(Level.Iteration)
	public void setupIteration() {
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.2")
	@BenchmarkMetaData(key = "libDescription", value = "High-performance, non-blocking architecture for the next generation of messaging applications.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.all")
	@BenchmarkMetaData(key = "title", value = "Sending messages")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void produce(Blackhole bh) throws JMSException {
		myProducer.produce(totalProducedMessages, messageByteSize);
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@TearDown(Level.Iteration)
	public void tearDownIteration() {
	}

}