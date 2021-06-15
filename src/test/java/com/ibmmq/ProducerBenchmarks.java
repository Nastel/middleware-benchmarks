
package com.ibmmq;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
public class ProducerBenchmarks {


    @Setup(Level.Trial)
    public void setup() {
        //TODO Trial level: write code to be executed before each run of the benchmark
    }

    @Setup(Level.Iteration)
    public void setupIteration() {
        //TODO Iteration level: write code to be executed before each iteration of the benchmark.
    }

    @TearDown(Level.Trial)
    public void tearDown() {
        //TODO Trial level: write code to be executed after each run of the benchmark
    }

    @TearDown(Level.Iteration)
    public void tearDownIteration() {
        //TODO Iteration level: write code to be executed after each iteration of the benchmark.
    }

}
