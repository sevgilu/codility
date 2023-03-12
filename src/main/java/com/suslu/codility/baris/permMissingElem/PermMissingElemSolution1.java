package com.suslu.codility.baris.permMissingElem;

import java.util.Arrays;

public class PermMissingElemSolution1 implements PermMissingElem {

    @Override
    public int findMissingElement(int[] A) {
        validateInput(A);
        int missing = 0;
        int size = A.length;
        if(size > 0 ) {
            // From documentation: This algorithm offers O(n log(n))
            Arrays.sort(A);
            // O(N)
            for (int i = 0; i < size; i++) {
                int n = i+1;
                if(n != A[i]) {
                    missing = n;
                    break;
                }
            }
            if(missing == 0){ // means last element is missing
                missing = size+1;
            }
        }
        return missing;
    }
}
