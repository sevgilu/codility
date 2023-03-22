package com.suslu.codility.binarygap;

import com.suslu.codility.exception.InvalidInputException;

public interface BinaryGap {
    int findLongestBinaryGap(int N);

    default void validateInput(int N) {
        if(N < 1) {
            throw new InvalidInputException("Invalid Input");
        }
    }
}
