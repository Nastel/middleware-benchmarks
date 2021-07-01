package com.activemq.classic;

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
public class ActiveMQProducerBenchmarks {
	private ActiveMQProducer myProducer;

	@Setup(Level.Trial)
	public void setup() {
		myProducer = new ActiveMQProducer();
	}

	@TearDown(Level.Trial)
	public void tearDown() {
		myProducer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-100-512b")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce1(Blackhole bh) {
		myProducer.produce(100, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-1000-512b")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 512 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce2(Blackhole bh) {
		myProducer.produce(1000, 512);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-100-1k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce3(Blackhole bh) {
		myProducer.produce(100, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-1000-1k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 1024 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce4(Blackhole bh) {
		myProducer.produce(1000, 1024);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-100-10k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce5(Blackhole bh) {
		myProducer.produce(100, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-1000-10k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 10240 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce6(Blackhole bh) {
		myProducer.produce(1000, 10240);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-100-32k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce7(Blackhole bh) {
		myProducer.produce(100, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-1000-32k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 32768 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce8(Blackhole bh) {
		myProducer.produce(1000, 32768);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-100-64k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 100 msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce9(Blackhole bh) {
		myProducer.produce(100, 65536);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0 Base")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "Send-1000-64k")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Producing 1000 msgs of 65536 bytes")
	@BenchmarkMetaData(key = "description", value = "JMS Producer, ActiveMQ Connection, no msg persistence, auto msg acknowledge")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 100, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 15, time = 1, timeUnit = TimeUnit.NANOSECONDS)
	public void activeProduce10(Blackhole bh) {
		myProducer.produce(1000, 65536);
	}

}