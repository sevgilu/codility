package com.suslu.codility.countingelements.missinginteger;

public class MissingIntegerSolution1 implements MissingInteger {
    @Override
    public int findMinimumMissingPositiveInteger(int[] A) {
        validateInput(A);
        int missingInteger = 0;
        int[] counter = new int[1000001];
        boolean positiveExist = false;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            validateInput(value);
            if (value > 0) {
                positiveExist = true;
                counter[value] =  counter[value] + 1;
            }
        }

        if(positiveExist) {
            for (int i = 1; i < counter.length; i++) {
                int count = counter[i];
                if(count == 0) {
                    missingInteger = i;
                    break;
                }
            }
            if(missingInteger == 0) {
                missingInteger = A.length + 1;
            }
        } else {
            missingInteger = 1;
        }

        return missingInteger;
    }
}
