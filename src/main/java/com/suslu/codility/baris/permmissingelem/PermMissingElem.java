package com.suslu.codility.baris.permmissingelem;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
public interface PermMissingElem {
    int findMissingElement(int[] A);

    default void validateInput(int[] A) {
        if(A == null)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
