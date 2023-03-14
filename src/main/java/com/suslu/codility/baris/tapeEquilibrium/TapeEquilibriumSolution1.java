package com.suslu.codility.baris.tapeEquilibrium;

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
        int index = 0;
        validateInput(A[index]);
        int sumLeft = 0;
        int sumRight = Arrays.stream(A).sum();

        // initalizeMinDiff
        int minDiff = Math.abs(sumRight - (2*A[0]));
        do {
            int currentValue = A[index];
            sumLeft = sumLeft + currentValue;
            sumRight -= currentValue;
            int tempDiff = Math.abs(sumLeft - sumRight);

            if(minDiff > tempDiff) {
                minDiff = tempDiff;
            }
            index++;
            validateInput(A[index]);
        }while(index < n-1);

        return minDiff;
    }
}
