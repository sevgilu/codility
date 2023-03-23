package com.suslu.codility.prefixsums.countdiv;

public class CountDivSolution1 implements CountDiv {
    @Override
    public int findDivisibleCount(int A, int B, int K) {
        validateInputs(A, B, K);
        int count = 0;

        for (int i = A; i <= B; i++) {
            if (i%K == 0) {
                count++;
            }
        }

        return count;
    }

}
