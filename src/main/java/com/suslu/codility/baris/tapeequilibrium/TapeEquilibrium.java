package com.suslu.codility.baris.tapeequilibrium;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public interface TapeEquilibrium {
    int findMinimumAbsoluteDifference(int[] A);

    default void validateInput(int[] A){
        if(A == null)
            throw new InvalidInputException("Input array can not be null or empty.");
        if(A.length < 2)
            throw new InvalidInputException("Input array has at least 2 elements");
        if(A.length > 100000)
            throw new InvalidInputException("Input array has at most 100000 elements");
    }

    default void validateInput(int i){
        if(i < -1000 || i > 1000)
            throw new InvalidInputException("Integer value must be -1000 <= value <= 10000");
    }

}
