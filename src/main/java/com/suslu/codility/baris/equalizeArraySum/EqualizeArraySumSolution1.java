package com.suslu.codility.baris.equalizeArraySum;

import java.util.Arrays;

public class EqualizeArraySumSolution1 implements EqualizeArraySum {
    @Override
    public boolean isEqualizationPossible(int[] a, int[] b) {
        validateInput(a, b);
        long sumA = Arrays.stream(a)
                .mapToLong(i->i).sum();
        long sumB = Arrays.stream(b)
                .mapToLong(i->i).sum();

        long total = sumA + sumB;
        if(total%2 == 1) {  // odd sum can not be divided equally
            return false;
        }
        long diff = Math.abs((total/2) - sumA);

        for (int i = 0; i < a.length; i++) {
            int currentA = a[i];
            for (int j = 0; j < b.length; j++) {
                int currentB = b[j];
                if(diff == Math.abs(currentA -currentB));
                    return true;
            }
        }

        return false;
    }
}
