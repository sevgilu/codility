package com.suslu.codility.fibonacci;

import java.time.Duration;
import java.time.Instant;

public class FibonacciTest {
    public static void main(String[] args) {
        int order = 45;
        int test = 100_000;

        printFibonacciWithTimeSpent(new FibonacciSolutionOne(), order);
        printFibonacciWithTimeSpent(new FibonacciSolutionTwo(), order);;

        printFibonacciWithTimeSpent(new FibonacciCalculator() {
            @Override
            public int getFibonacci(int n) {
                return FibonacciCalculator.super.getFibonacci(n);
            }
        }, order);
    }

    public static void printFibonacciWithTimeSpent(FibonacciCalculator calculator,  int order){
        Instant start = Instant.now();
        int result = calculator.getFibonacci(order);
        Instant end = Instant.now();

        System.out.println("result: " + result +
                ", calculation duration:" + Duration.between(start, end).toMillis() +
                ", class:" + calculator.getClass().getName());
    }

}
