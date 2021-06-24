
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
@BenchmarkMetaData(key = "context", value = "Consume")
@BenchmarkMetaData(key = "domain", value = "java")
public class RabbitConsumerBenchmarks {
	private RabbitConsumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new RabbitConsumer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume2(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume3(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume4(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume5(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume6(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume7(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume8(Blackhole bh) {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume9(Blackhole bh) {
		myConsumer.consume(1000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libVersion", value = "3.8.17")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key = "description", value = "Consumed 10000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10(Blackhole bh) {
		myConsumer.consume(10000);
	}

}
