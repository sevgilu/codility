package com.suslu.codility.fibonacci;

public class FibonacciSolutionOne implements FibonacciCalculator {
    @Override
    public int getFibonacci(int n) {
        int result = 0;

        if (n == 0 || n == 1) {
            return n;
        } else {
            int prev2 = 0;
            int prev1 = 1;
            int i = 2;

            while(i<=n) {
                result = prev1 + prev2;
                prev2 = prev1;
                prev1 = result;
                i++;
            }

            return result;
        }

    }

}
