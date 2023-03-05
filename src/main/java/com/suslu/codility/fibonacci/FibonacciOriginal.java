package com.suslu.codility.fibonacci;

public class FibonacciOriginal {

    public static void main(String[] args) {
        for (int i = 0; i < 15 ; i++) {
            System.out.println(FibonacciOriginal.getFibonacci(i));
        }
    }
    public static int getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }
}
