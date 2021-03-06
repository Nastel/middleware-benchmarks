# Benchmarks for Middleware Message Queue Platforms

### Versions
API | Version (Built with Maven)
-- | -- 
ActiveMQ Classic | ***5.16.0***
Artemis | ***2.17.0***
IBM MQ | ***9.2.2.0***
Kafka | ***1.0.1***
RabbitMQ | ***5.12.0***
*JMS* | ***2.0.1***
*JMH* | ***1.26***
*Cybench* | ***1.0.0***


### Benchmark Details
- Built using JMH and [Cybench™](https://cybench.io/)
- ***PARAM***  File Size (bytes)
  - 512
  - 1024 (1kb)
  - 10240 (10kb)
  - 32768 (32kb)
  - 65536 (64kb)
- ***PARAM***  Persistence
  - Produce persistent messages
  - Consume persistent messages
- Producer
  - All messages produced to the same respective queue per MQ
  - 10 trials
    - 15 warm-up iterations
    - 100 measurement iterations
  - ***PARAM***  Total Messages Produced
    - 100 msgs
    - 1,000 msgs
  - ***PARAM***  Concurrency
    - Produce with concurrent consumer running (concurrent)
      - Must run respective *Consumer.java* class' main method during benchmark
    - Produce without concurrent consumer running (nonconcurrent)
- Consumer
  - Pre-fill five individual queues based on message size using respective *Producer.java* class' main method
  - 10 trials
    - 1 warm-up iteration (used for consumer connection and removing overhead)
    - 10 measruement iterations
  - ***PARAM***  Total Messages Consumed
    - 1,000 msgs
    - 10,000 msgs
    
