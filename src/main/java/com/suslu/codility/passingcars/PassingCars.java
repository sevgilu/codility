package com.suslu.codility.passingcars;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/
public interface PassingCars {
    int findPassingCarCount(int[] A);

    default void validateInput(int[] A) {
        if(A == null || A.length == 0 || A.length > 100000) {
            throw  new InvalidInputException("Invalid input.");
        }
    }

    default void validateInput(int value) {
        if(value != 1 && value != 0) {
            throw  new InvalidInputException("Invalid input.");
        }
    }
}
