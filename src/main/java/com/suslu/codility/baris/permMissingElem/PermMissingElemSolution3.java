package com.suslu.codility.baris.permMissingElem;

import java.util.Arrays;

public class PermMissingElemSolution3 implements PermMissingElem {
    @Override
    public int findMissingElement(int[] intArray) {
        validateInput(intArray);
        int size = intArray.length;
        if(size == 0) {
            return 0;
        } else{
            int n = size + 1;
            int expectedSum = (n * (n +1)) / 2;
            int actualSum = Arrays.stream(intArray).sum();
            return expectedSum-actualSum;
        }
    }

}
