package com.example;    

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
 
@State(Scope.Thread)
public class BenchmarkExample {
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void printHelloWorld() {
        System.out.println("Hello World");  
        }

  }

