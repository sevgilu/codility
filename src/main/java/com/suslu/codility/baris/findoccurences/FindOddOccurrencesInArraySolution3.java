package com.suslu.codility.baris.findoccurences;

import java.util.HashSet;
import java.util.Set;

public class FindOddOccurrencesInArraySolution3 implements FindOddOccurrencesInArray {
    // (after review with baris)
    @Override
    public int findOddOccurrences(int[] A) {
        validateInput(A);
        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            boolean added = set.add(i);
            if(!added) { // if already exist in set
                set.remove(i);
            }
        }
        Object[] unpaired = set.toArray();

        return Integer.parseInt(unpaired[0].toString());
    }

}
