package com.suslu.codility.baris.tapeequilibrium;

import java.util.Arrays;

public class TapeEquilibriumSolution1 implements TapeEquilibrium {

    /**
    * n -> [2, 100000]
    * p -> 0 < p < n
    **/
    @Override
    public int findMinimumAbsoluteDifference(int[] A) {
        validateInput(A);
        int n = A.length;
        validateInput(A[0]);
        validateInput(A[n-1]);
        int sumLeft = A[0];
        int sumRight = Arrays.stream(A).sum()-sumLeft;

        // initializeMinDiff
        int minDiff = Math.abs(sumRight - sumLeft);

        for (int i = 1; i < n-1; i++) {
            int currentValue = A[i];
            validateInput(currentValue);
            sumLeft = sumLeft + currentValue;
            sumRight -= currentValue;
            int tempDiff = Math.abs(sumLeft - sumRight);
            minDiff = Math.min(minDiff, tempDiff);
        }

        return minDiff;
    }
}
