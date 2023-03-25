package com.suslu.codility.prefixsums.genomicrangequery;

// Prefix minimum query solutions: Sparse table
// https://www.geeksforgeeks.org/range-minimum-query-for-static-array/
// https://www.baeldung.com/cs/sparse-tables
//
// Task Score = 100
// Correctness = 100
// Performance = 100
public class GenomicRangeQuerySolution3 implements GenomicRangeQuery {
    @Override
    public int[] findMinimalImpacts(String S, int[] P, int[] Q) {
        validateInputs(S, P, Q);
        char[] nucleotides = S.toCharArray();
        int[][] lookup = prepareLookup(nucleotides);
        return findImpacts(lookup, nucleotides.length,  P, Q);
    }

    private int[] findImpacts(int[][] lookup, int nucleotideCount, int[] P, int[] Q) {
        int queryCount = P.length;
        int[] result = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int start = P[i];
            int end = Q[i];
            validateIntegerPairsInArray(nucleotideCount, start, end);

            int j = (int) ( Math.log(end-start+1) / Math.log(2) ) ;
            int row = end - (1 << j) + 1; // i + (2 ^ (j-1))
            result[i] = Math.min(lookup[start][j], lookup[row][j]);
        }
        return result;
    }
    private int[][] prepareLookup(char[] nucleotides) {
        int nucleotideCount = nucleotides.length;
        int maxColumn = (int) ( Math.log(nucleotideCount) / Math.log(2)) + 1;
        // NOTE: careful about the allocation
        // new int[nucleotideCount][maxColumn] -> this cause performance score 0
        int[][] lookup = new int[nucleotideCount][maxColumn];

        for (int i = 0; i < nucleotideCount; i++) {
            lookup[i][0] = getImpact(nucleotides[i]);
        }
        // for j=1 to log n  here log base 2 and n = nucleotideCount
        for (int j = 1; (1 << j) <=nucleotideCount; j++) {

            for (int i = 0; (i + (1 << j) - 1) < nucleotideCount; i++) {
                int row = i + (1 << (j-1)); // i + (2 ^ (j-1))
                lookup[i][j] = Math.min( lookup[i][j-1], lookup[row][j-1]);
            }

        }
        return lookup;
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
