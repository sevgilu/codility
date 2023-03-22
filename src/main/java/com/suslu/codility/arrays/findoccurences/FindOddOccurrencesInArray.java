package com.suslu.codility.arrays.findoccurences;

import com.suslu.codility.exception.InvalidInputException;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public interface FindOddOccurrencesInArray {

    int findOddOccurrences(int[] A);

    default void validateInput(int[] A) {
        if(A == null || A.length == 0)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
