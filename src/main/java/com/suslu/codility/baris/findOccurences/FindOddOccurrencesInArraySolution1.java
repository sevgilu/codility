package com.suslu.codility.baris.findOccurences;

import java.util.HashSet;
import java.util.Set;

public class FindOddOccurrencesInArraySolution1 implements FindOddOccurrencesInArray {

    // aynı sayı 2 den fazla eklendiğinde hatalı çalışıyor
    @Override
    public int solution(int[] intArray) {
        validateInput(intArray);
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i : intArray) {
            int factor = set.contains(i) ? -1 : 1;
            set.add(i);
            sum += i * factor;
        }

        return sum;
    }
}
