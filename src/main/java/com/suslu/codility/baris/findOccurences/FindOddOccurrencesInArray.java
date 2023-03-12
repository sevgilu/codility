package com.suslu.codility.baris.findOccurences;

import com.suslu.codility.exception.InvalidInputException;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public interface FindOddOccurrencesInArray {

    int solution(int[] intArray);

    default void validateInput(int[] intArray) {
        if(intArray == null || intArray.length == 0)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
