package com.suslu.codility.fibonacci;

public class FibonacciSolutionTwo implements FibonacciCalculator {

    @Override
    public int getFibonacci(int n) {
        int result;

        if (n == 0 || n == 1) {
            result = n;
        } else {
            int series[] = new int[n + 1];
            series[0] = 0;
            series[1] = 1;
            int i = 2;

            while (i <= n) {
                series[i] = series[i - 1] + series[i - 2];
                i++;
            }

            result = series[n];
        }

        return result;
    }
}
