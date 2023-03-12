package com.suslu.codility.baris.findOccurences;

import java.util.HashSet;
import java.util.Set;

public class FindOddOccurrencesInArraySolution2 implements FindOddOccurrencesInArray {

    @Override
    public int findOddOccurrences(int[] intArray) {
        validateInput(intArray);
        Set<Integer> set = new HashSet<>();

        for (int i : intArray) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        Object[] unpaired = set.toArray();

        return Integer.parseInt(unpaired[0].toString());
    }
}
