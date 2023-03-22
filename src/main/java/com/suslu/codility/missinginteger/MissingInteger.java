package com.suslu.codility.missinginteger;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
public interface MissingInteger {
    int findMinimumMissingPositiveInteger(int[] A);

    default void validateInput(int[] A) {
        if(A == null || A.length < 1 || A.length > 100000) {
            throw  new InvalidInputException("Invalid input.");
        }
    }

    default void validateInput(int value) {
        if (value < -1000000 || value > 1000000) {
            throw  new InvalidInputException("Invalid input.");
        }
    }
}
