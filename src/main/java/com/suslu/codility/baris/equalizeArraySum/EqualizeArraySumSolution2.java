package com.suslu.codility.baris.equalizeArraySum;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EqualizeArraySumSolution2 implements EqualizeArraySum {
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
        Set<Long> setToDecrease = Arrays.stream(arrayToDecrease)
                .boxed()
                .map(i -> Long.valueOf(i))
                .collect(Collectors.toSet());

        for (int i = 0; i < arrayToIncrease.length; i++) {
            long toIncrease = arrayToIncrease[i];
            long searchFor = toIncrease + diffToSwitch;
            if( ! setToDecrease.add(searchFor)) { // desired number exits in the other data
                return true;
            }
        }

        return false;
    }
}
