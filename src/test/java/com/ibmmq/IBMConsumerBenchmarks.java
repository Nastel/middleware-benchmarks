package com.ibmmq;

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
@BenchmarkMetaData(key = "isLibraryBenchmark-NonP", value = "true")
//@BenchmarkMetaData(key = "context", value = "ConcurrentConsume")
//@BenchmarkMetaData(key = "context", value = "NonconcurrentConsume")
@BenchmarkMetaData(key = "domain", value = "java")
public class IBMConsumerBenchmarks {
	private IBMConsumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new IBMConsumer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-512b-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume1000msg512b(Blackhole bh) {
		myConsumer.consume(1000, "DEV.myQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-512b-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume10000msg512b(Blackhole bh) {
		myConsumer.consume(10000, "DEV.myQueue1");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-1k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume1000msg1k(Blackhole bh) {
		myConsumer.consume(1000, "DEV.myQueue2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-1k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume10000msg1k(Blackhole bh) {
		myConsumer.consume(10000, "DEV.myQueue2");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-10k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume1000msg10k(Blackhole bh) {
		myConsumer.consume(1000, "DEV.myQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-10k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume10000msg10k(Blackhole bh) {
		myConsumer.consume(10000, "DEV.myQueue3");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-32k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume1000msg32k(Blackhole bh) {
		myConsumer.consume(1000, "DEV.myQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-32k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume10000msg32k(Blackhole bh) {
		myConsumer.consume(10000, "DEV.myQueue4");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-1000-64k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 1000 msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume1000msg64k(Blackhole bh) {
		myConsumer.consume(1000, "DEV.myQueue5");
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Persistent")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Persistent")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Receive-10000-64k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Consuming 10000 msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.get(), MQQueueManager, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmConsume10000msg64kk(Blackhole bh) {
		myConsumer.consume(10000, "DEV.myQueue5");
	}

}
