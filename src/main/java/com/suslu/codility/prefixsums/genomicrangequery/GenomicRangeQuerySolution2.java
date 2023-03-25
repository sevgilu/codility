package com.suslu.codility.prefixsums.genomicrangequery;


// brute force wiht lookup
// https://www.geeksforgeeks.org/range-minimum-query-for-static-array/
//
// Task Score = 62
// Correctness = 100
// Performance = 0
public class GenomicRangeQuerySolution2 implements GenomicRangeQuery {
    @Override
    public int[] findMinimalImpacts(String S, int[] P, int[] Q) {
        validateInputs(S, P, Q);

        int[] impactArray = convertToImpact(S);
        int[][] lookup = prepareLookup(impactArray);

        return findImpacts(lookup, S, P, Q);
    }

    private int[] findImpacts(int[][] lookup, String S, int[] P, int[] Q) {
        int queryCount = P.length;
        int[] result = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int start = P[i];
            int end = Q[i];
            validateIntegerPairsInArray(S.length(), start, end);
            result[i] = lookup[start][end];
        }
        return result;
    }

    private int[][] prepareLookup(int[] impactArray) {
        int nucleotideCount = impactArray.length;
        int[][] lookup = new int[nucleotideCount][nucleotideCount];

        for (int i = 0; i < nucleotideCount ; i++) {
            lookup[i][i] = impactArray[i];
            for (int j = i+1; j < nucleotideCount; j++) {
                lookup[i][j] = Math.min( lookup[i][j-1], impactArray[j] );
            }
        }
        return lookup;
    }

    private int[] convertToImpact(String S) {
        char[] nucleotides = S.toCharArray();
        int nucleotideCount = nucleotides.length;
        int[] impacts = new int[nucleotideCount];

        for (int i = 0; i < nucleotideCount ; i++) {
            impacts[i] = getImpact(nucleotides[i]);
        }
        return impacts;
    }
    private int getImpact(char c) {
        if('A' == c ) {
            return 1;
        } else if('C' == c) {
            return 2;
        } else if('G' == c) {
            return 3;
        } else if('T' == c) {
            return 4;
        } else {
            throw new IllegalArgumentException("Illegal char");
        }
    }
}
