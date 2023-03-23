package com.suslu.codility.prefixsums.countdiv;

public class CountDivSolution2 implements CountDiv {
    @Override
    public int findDivisibleCount(int A, int B, int K) {
        validateInputs(A, B, K);
        int countInA = A / K;
        if(A % K == 0) {
            countInA--;
        }
        int countInB = B / K;
        return countInB - countInA;
    }

}
