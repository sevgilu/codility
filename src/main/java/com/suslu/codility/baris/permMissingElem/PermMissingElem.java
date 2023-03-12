package com.suslu.codility.baris.permMissingElem;

import com.suslu.codility.exception.InvalidInputException;

public interface PermMissingElem {
    int findMissingElement(int[] A);

    default void validateInput(int[] A) {
        if(A == null)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
