package com.suslu.codility.baris.equalizeArraySum;

import com.suslu.codility.exception.InvalidInputException;

public interface EqualizeArraySum {

    boolean isEqualizationPossible(int[] a, int[] b);

    default void validateInput(int[] a, int[] b) {
        if(a == null || b == null ||
                a.length == 0  || b.length == 0) {
            throw new InvalidInputException("Input arrays can not be null or empty");
        }
        if(a.length != b.length) {
            throw new InvalidInputException("Input arrays must have the save size");
        }
    }

}
