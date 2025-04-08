package com.example;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;// Benchmark mod
import org.openjdk.jmh.annotations.Measurement;// Measurement phase
import org.openjdk.jmh.annotations.Mode; 
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


@State(Scope.Thread) // Each thread gets its own state instance
@Warmup(iterations = 1) // Warmup phase with 1 iteration
@BenchmarkMode(Mode.All) // Measure average time taken  
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Measure performance in milliseconds
@Measurement(iterations =1, time = 1,timeUnit=TimeUnit.SECONDS) // Measurement phase with 5 iterations, each lasting 10 seconds
public class AppTest {

    // method to measure the performance of different summation methods
private int[] numbers;
    @Setup
    @Benchmark
    public void setup() {
        // Initialize the numbers array with 1000 elements
        numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }
@Benchmark
    public long sumUsingStreams() {
        return java.util.Arrays.stream(numbers).asLongStream().sum();
    }
   

    // @Benchmark
    // public long sumUsingParallelStreams() {
    //     return java.util.Arrays.stream(numbers).asLongStream().parallel().sum();
    // }

    @Benchmark
    public long sumUsingForEach() {
        final long[] sum = {0};
        java.util.Arrays.stream(numbers).forEach(value -> sum[0] += value);
        return sum[0];
    }

    @Benchmark
    public long sumUsingForLoop() {
        long sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(AppTest.class.getSimpleName()) // Include the benchmark class
                .forks(1) // Number of forked JVMs
                .build();

        new Runner(options).run(); // Run the benchmark
    }
}

