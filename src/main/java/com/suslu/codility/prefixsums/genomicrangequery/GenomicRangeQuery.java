package com.suslu.codility.prefixsums.genomicrangequery;

import com.suslu.codility.exception.InvalidInputException;

// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
public interface GenomicRangeQuery {
    int[] findMinimalImpacts(String S, int[] P, int[] Q);

    default void validateInputs(String S, int[] P, int[] Q){
        validateInputString(S);
        validateInputArray(P);
        validateInputArray(Q);
        if(P.length != Q.length) {
            throw new InvalidInputException("Not equal arrays.");
        }
    }
    default void validateIntegerPairsInArray(int length, int valueP, int valueQ) {
        if(valueP >= length || valueQ >= length || valueP > valueQ) {
            throw new InvalidInputException("Invalid integer in array.");
        }
    }

    private void validateInputString(String S){
        if(S == null || S.length() == 0 || S.length() > 100000 ||
                S.replaceAll("A*C*G*T*", "").length() != 0) {
            throw new InvalidInputException("Invalid string.");
        }
    }
    private void validateInputArray(int[] array){
        if(array == null || array.length == 0 || array.length > 50000) {
            throw new InvalidInputException("Invalid array.");
        }
    }


}
