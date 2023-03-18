package com.suslu.codility.baris.equalizearraysum;

import java.util.Arrays;

public class EqualizeArraySumSolution1 implements EqualizeArraySum {
    @Override
    public boolean isEqualizationPossible(int[] a, int[] b) {
        validateInput(a, b);
        long sumA = Arrays.stream(a)
                .mapToLong(i->i).sum();
        long sumB = Arrays.stream(b)
                .mapToLong(i->i).sum();

        long diff = Math.abs(sumA - sumB);
        if(diff % 2 == 1) {  // odd diff can not be divided equally
            return false;
        }
        long diffToSwitch = diff /2;
        return sumA > sumB ?
                doesSwitchWork(a, b, diffToSwitch) :
                doesSwitchWork(b, a, diffToSwitch);
    }

    private boolean doesSwitchWork(int[] arrayToDecrease, int[] arrayToIncrease, long diffToSwitch){
        for (int i = 0; i < arrayToIncrease.length; i++) {
            int valueToIncrease = arrayToIncrease[i];
            for (int j = 0; j < arrayToDecrease.length; j++) {
                long valueToDecrease = arrayToDecrease[j];
                if(diffToSwitch == (valueToDecrease - valueToIncrease)) {
                    return true;
                }
            }
        }

        return false;
    }
}
