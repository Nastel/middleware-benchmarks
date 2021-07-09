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
@BenchmarkMetaData(key = "context", value = "NonconcurrentConsume")
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
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1000msg512b(Blackhole bh) {
		myConsumer.consume(1000, "myQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10000msg512b(Blackhole bh) {
		myConsumer.consume(10000, "myQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1000msg1k(Blackhole bh) {
		myConsumer.consume(1000, "myQueue2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10000msg1k(Blackhole bh) {
		myConsumer.consume(10000, "myQueue2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1000msg10k(Blackhole bh) {
		myConsumer.consume(1000, "myQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 102400 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10000msg10k(Blackhole bh) {
		myConsumer.consume(10000, "myQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1000msg32k(Blackhole bh) {
		myConsumer.consume(1000, "myQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10000msg32k(Blackhole bh) {
		myConsumer.consume(10000, "myQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 1000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume1000msg64k(Blackhole bh) {
		myConsumer.consume(1000, "myQueue5");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libVendor", value = "RabbitMQ")
	@BenchmarkMetaData(key = "libUrl", value = "https://github.com/rabbitmq/rabbitmq-server/releases/")
	@BenchmarkMetaData(key = "libDescription", value = "RabbitMQ is the most widely deployed open source message broker.")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.rabbitmq.amqp-client")	
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 NonPersistent")
//	@BenchmarkMetaData(key = "libVersion", value = "3.8.17 Persistent")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-P")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "title", value = "Consuming 10000 persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), no msg persistence, auto msg acknowledgement")
//	@BenchmarkMetaData(key = "description", value = "RabbitMQ Client Connection basicGet(), msg persistence, auto msg acknowledgement")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.NANOSECONDS)
	public void rabbitConsume10000msg64k(Blackhole bh) {
		myConsumer.consume(10000, "myQueue5");
	}

}
