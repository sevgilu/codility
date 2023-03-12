package com.suslu.codility.baris.permMissingElem;

public class PermMissingElemSolution2 implements PermMissingElem {

    @Override
    public int findMissingElement(int[] A) {
        validateInput(A);
        int size = A.length;
        if(size == 0) {
            return 1;
        } else{
            long n = size + 1;
            long expectedSum = (n * (n +1)) / 2;
            long actualSum = 0;
            for (int i = 0; i < size; i++) {
                actualSum += A[i];
            }
            return (int) (expectedSum-actualSum);
        }
    }
}
