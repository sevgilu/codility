package com.suslu.codility.baris.permMissingElem;

import com.suslu.codility.exception.InvalidInputException;

public interface PermMissingElem {
    int findMissingElement(int[] intArray);

    default void validateInput(int[] intArray) {
        if(intArray == null)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
