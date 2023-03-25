package com.suslu.codility.prefixsums.genomicrangequery;

// my first solution
// no approach for range query (range minimum query) or prefix minimum query problem
// Task Score = 75
// Correctness = 100
// Performance = 33


public class GenomicRangeQuerySolution1 implements GenomicRangeQuery {
    @Override
    public int[] findMinimalImpacts(String S, int[] P, int[] Q) {
        validateInputs(S, P, Q);
        int queryCount = P.length;
        int[] result = new int[queryCount];

        for (int i = 0; i < queryCount; i++) {
            int valueP = P[i];
            int valueQ = Q[i];
            validateIntegerPairsInArray(S.length(), valueP, valueQ);
            result[i] = findImpact(S.substring(valueP, valueQ+1));
        }
        
        return result;
    }
    private int findImpact(String query) {
        if(query.contains("A")) {
            return 1;
        } else if(query.contains("C")) {
            return 2;
        } else if(query.contains("G")) {
            return 3;
        } else if(query.contains("T")) {
            return 4;
        }
        return 0;
    }
}
