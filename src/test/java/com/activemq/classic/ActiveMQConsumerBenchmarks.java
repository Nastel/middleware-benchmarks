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
//@BenchmarkMetaData(key = "context", value = "SynchronousConsume")
//@BenchmarkMetaData(key = "context", value = "Consume")
@BenchmarkMetaData(key = "domain", value = "java")
public class ActiveMQConsumerBenchmarks {
	private ActiveMQConsumer myConsumer;

	@Setup(Level.Trial)
	public void setup() {
		myConsumer = new ActiveMQConsumer();
	}
	
	@TearDown(Level.Trial)
	public void tearDown() {
		myConsumer.closeConnection();
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume1(Blackhole bh)  {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 512 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume2(Blackhole bh)  {
		myConsumer.consume(10000);
	}

	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume3(Blackhole bh)  {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 1024 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume4(Blackhole bh)  {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume5(Blackhole bh)  {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 10240 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume6(Blackhole bh)  {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume7(Blackhole bh)  {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 32768 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume8(Blackhole bh)  {
		myConsumer.consume(10000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 1000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume9(Blackhole bh)  {
		myConsumer.consume(1000);
	}
	
	@Benchmark
	@BenchmarkMetaData(key = "api", value = "ActiveMQ Classic")
	@BenchmarkMetaData(key = "libVendor", value = "Apache")
	@BenchmarkMetaData(key = "libUrl", value = "https://activemq.apache.org/components/classic/")
	@BenchmarkMetaData(key = "libVersion", value = "5.16.0")
	@BenchmarkMetaData(key = "libDescription", value = "Apache ActiveMQ® is the most popular open source, multi-protocol, Java-based message broker. It supports industry standard protocols so users get the benefits of client choices across a broad range of languages and platforms. Connect from clients written in JavaScript, C, C++, Python, .Net, and more. Integrate your multi-platform applications using the ubiquitous AMQP protocol. Exchange messages between your web applications using STOMP over websockets. Manage your IoT devices using MQTT. Support your existing JMS infrastructure and beyond. ActiveMQ offers the power and flexibility to support any messaging use-case.")
	@BenchmarkMetaData(key = "actionName", value = "consume")
	@BenchmarkMetaData(key = "libSymbolicName", value = "org.apache.activemq.activemq-all")
	@BenchmarkMetaData(key = "title", value = "Consuming Messages")
	@BenchmarkMetaData(key="description", value="Consumed 10000 messages of size 65536 bytes per iteration")
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	@Fork(1)
	@Threads(1)
	@Measurement(iterations = 10, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	@Warmup(iterations = 1, time = 100, timeUnit = TimeUnit.NANOSECONDS)
	public void activeConsume10(Blackhole bh)  {
		myConsumer.consume(10000);
	}


}
