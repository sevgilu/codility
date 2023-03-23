package com.suslu.codility.prefixsums.countdiv;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
public interface CountDiv {
    int LIMIT = 2000000000;
    int findDivisibleCount(int A, int B, int K);

    default void validateInputs(int A, int B, int K) {
        if( A < 0 || A > LIMIT ||
                B < 0 || B > LIMIT ||
                A > B ||
                K < 1 || K > LIMIT ) {
            throw  new InvalidInputException("Invalid input");
        }
    }
}
