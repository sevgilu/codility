package com.suslu.codility;

import com.suslu.codility.exception.InvalidInputException;

import java.util.HashSet;
import java.util.Set;

//https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
public class FindOddOccurrencesInArray {

    public int solution1(int[] intArray) {
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

    private void validateInput(int[] intArray) {
        if(intArray == null || intArray.length == 0)
            throw new InvalidInputException("Input array can not be null or empty.");
    }

}
