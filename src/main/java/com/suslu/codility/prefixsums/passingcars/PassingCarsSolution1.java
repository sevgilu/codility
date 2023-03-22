package com.suslu.codility.prefixsums.passingcars;

public class PassingCarsSolution1 implements PassingCars {
    @Override
    public int findPassingCarCount(int[] A) {
        validateInput(A);
        long passingCars = 0;
        long toWestCount = 0;

        for (int i = A.length-1; i >=0 ; i--) {
            int value = A[i];
            validateInput(value);
            if(value == 1) {
                toWestCount++;
            } else {
                passingCars = passingCars + toWestCount;
            }
        }

        return passingCars > 1000000000 ? -1 : (int)passingCars;
    }
}
