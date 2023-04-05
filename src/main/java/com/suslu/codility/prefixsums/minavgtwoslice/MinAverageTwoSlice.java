package com.suslu.codility.prefixsums.minavgtwoslice;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

public interface MinAverageTwoSlice {
    int findMinimumAverage(int[] A);

    default void validateInput(int[] A){
        if(A == null || A.length < 2 || A.length > 100000) {
            throw new InvalidInputException("Invalid array.");
        }
    }
    default void validateInputValue(int value){
        if(value < -10000 || value > 10000) {
            throw new InvalidInputException("Invalid value.");
        }
    }
}
