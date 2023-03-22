package com.suslu.codility.iterations.binarygap;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
public interface BinaryGap {
    int findLongestBinaryGap(int N);

    default void validateInput(int N) {
        if(N < 1) {
            throw new InvalidInputException("Invalid Input");
        }
    }
}
