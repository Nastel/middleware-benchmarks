
package com.rabbitmq;

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
@BenchmarkMetaData(key = "context", value = "SynchronousProduce")
@BenchmarkMetaData(key = "domain", value = "java")
public class RabbitSyncProducerBenchmarks {
	private RabbitProducer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new RabbitProducer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce1(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce2(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce3(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce4(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce5(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce6(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce7(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce8(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 100 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce9(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "produce")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Producing Messages")
	@BenchmarkMetaData(key = "description", value = "Produced 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitProduce10(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
