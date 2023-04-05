package com.suslu.codility.prefixsums.minavgtwoslice;

// brute force solution to try test cases
//
// Task Score = 60
// Correctness = 100
// Performance = 20
public class MinAverageTwoSliceSolution1 implements MinAverageTwoSlice {
    @Override
    public int findMinimumAverage(int[] A) {
        validateInput(A);
        int count = A.length;
        int startingPosition = 0;

        double minimumAvr = (A[0]+A[1]) / 2.0;
        for (int i = 0; i < count-1; i++) {
            int value = A[i];
            validateInputValue(value);
            double total = value;
            double elementCount = 2;

            for (int j = (i+1); j < count; j++) {
                total = total + A[j];
                double average = total / elementCount;
                elementCount++;

                if(minimumAvr > average) {
                    minimumAvr = average;
                    startingPosition = i;
                }
            }
        }

        validateInputValue(A[count-1]);
        return startingPosition;
    }

}
