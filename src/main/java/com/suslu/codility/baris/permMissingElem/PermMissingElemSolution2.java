package com.suslu.codility.baris.permMissingElem;

public class PermMissingElemSolution2 implements PermMissingElem {

    @Override
    public int findMissingElement(int[] A) {
        validateInput(A);
        int size = A.length;
        if(size == 0) {
            return 0;
        } else{
            int n = size + 1;
            int expectedSum = (n * (n +1)) / 2;
            int actualSum = 0;
            for (int i = 0; i < size; i++) {
                actualSum += A[i];
            }
            return expectedSum-actualSum;
        }
    }
}
