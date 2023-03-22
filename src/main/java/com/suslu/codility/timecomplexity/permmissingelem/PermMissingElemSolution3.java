package com.suslu.codility.timecomplexity.permmissingelem;

import java.util.Arrays;

public class PermMissingElemSolution3 implements PermMissingElem {
    @Override
    public int findMissingElement(int[] A) {
        validateInput(A);
        int size = A.length;

        if(size == 0) {
            return 1;
        } else{
            long n = size + 1;
            long expectedSum = (n * (n +1)) / 2;
            long actualSum = Arrays.stream(A)
                    .mapToLong(i -> i)
                    .sum();
            long result = expectedSum-actualSum;

            return (int) result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
