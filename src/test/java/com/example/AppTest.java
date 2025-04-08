package com.example;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
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

//import jdk.internal.icu.text.NormalizerBase;

@State(Scope.Thread) // Each thread gets its own state instance
@Warmup(iterations = 1) // Warmup phase with 1 iteratio
@BenchmarkMode(Mode.AverageTime) // Measure average time taken  
@OutputTimeUnit(TimeUnit.MILLISECONDS) // Measure performance in milliseconds
public class AppTest {

    // Benchmark method to measure performance of printing "Hello, World!"
   // @Benchmark
    private int[] numbers;
    @Setup
    public void setup() {
        // Initialize the numbers array with 1000 elements
        numbers = new int[10000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }
    @Benchmark
    public long printHelloWorld() {
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

