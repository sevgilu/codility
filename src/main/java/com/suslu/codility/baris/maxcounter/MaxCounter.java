package com.suslu.codility.baris.maxcounter;

import com.suslu.codility.exception.InvalidInputException;

public interface MaxCounter {
    int[] calculateMaxCounters(int N, int[] A);

    default void validateInput(int N, int[] A) {
        if( N < 1 || N > 100000 ||
                A == null || A.length < 1 || A.length > 100000 ) {
            throw new InvalidInputException("Invalid input");
        }
    }

    default void validateInput(int N, int value) {
        if (value < 1 || value > N+1) {
            throw new InvalidInputException("Invalid input");
        }
    }

}
