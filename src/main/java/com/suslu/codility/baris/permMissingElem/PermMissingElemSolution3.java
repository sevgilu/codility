package com.suslu.codility.baris.permMissingElem;

import java.util.Arrays;

public class PermMissingElemSolution3 implements PermMissingElem {
    @Override
    public int findMissingElement(int[] A) {
        validateInput(A);
        int size = A.length;

        if(size == 0) {
            return 1;
        } else{
            int n = size + 1;
            long expectedSum = (n * (n +1)) / 2;
//            long actualSum = Arrays.stream(A)
//                    .mapToLong(i -> i)
//                    .sum();
            long[] longArray = Arrays.stream(A)
                    .mapToLong(i -> i)
                   .toArray();
            long actualSum = Arrays.stream(longArray).sum();

            return (int) (expectedSum-actualSum);
        }
    }

}
