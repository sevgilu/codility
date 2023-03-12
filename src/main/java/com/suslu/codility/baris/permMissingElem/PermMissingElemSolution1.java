package com.suslu.codility.baris.permMissingElem;

import java.util.Arrays;

public class PermMissingElemSolution1 implements PermMissingElem {

    @Override
    public int findMissingElement(int[] intArray) {
        validateInput(intArray);
        int missing = 0;
        int size = intArray.length;

        if(size > 0 ) {
            // From documentation: This algorithm offers O(n log(n))
            Arrays.sort(intArray);
            // O(N)
            for (int i = 0; i < size; i++) {
                int n = i+1;
                if(n != intArray[i]) {
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
