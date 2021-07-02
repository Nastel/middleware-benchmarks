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
@BenchmarkMetaData(key = "isLibraryBenchmark", value = "true")
//@BenchmarkMetaData(key = "context", value = "ConcurrentProduce")
//@BenchmarkMetaData(key = "context", value = "NonconcurrentProduce")
@BenchmarkMetaData(key = "domain", value = "java")
public class IBMProducerBenchmarks {
	private IBMProducer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new IBMProducer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg512b(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 512 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg512b(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg1k(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 1024 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg1k(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg10k(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 10240 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg10k(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg32k(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 32768 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg32k(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 100 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce100msg64k(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "IBM MQ")
	@BenchmarkMetaData(key = "libVendor", value = "IBM")
	@BenchmarkMetaData(key = "libUrl", value = "https://www.ibm.com/products/mq")
//	@BenchmarkMetaData(key = "libVersion", value = "9.2.2.0 Base")
//	@BenchmarkMetaData(key = "libVersion", value = "9.0.5.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "IBM MQ offers enterprise-grade messaging capabilities that skillfully and safely move information between applications.")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-NonP")
//	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k-P")
	@BenchmarkMetaData(key = "libSymbolicName", value = "com.ibm.mq.allclient")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 non persistent msgs of 65536 bytes")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, no msg persistence")
//	@BenchmarkMetaData(key = "description", value = "IBM MQQueue.put(), MQQueueManager, async response put message option, msg persistence")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void ibmProduce1000msg64k(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}
