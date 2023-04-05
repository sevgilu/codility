package com.suslu.codility.prefixsums.genomicrangequery;

// Baris in buldugu cozum
// https://funnelgarden.com/genomicrangequery-codility-solution/
// Detected time complexity: O(N + M)
// Task Score = 100
// Correctness = 100
// Performance = 100
public class GenomicRangeQuerySolution4 implements GenomicRangeQuery {
    private final int NUCLEOTIDE_SIZE = 4;
    @Override
    public int[] findMinimalImpacts(String S, int[] P, int[] Q) {
        validateInputs(S, P, Q);
        // prepare prefixSumLookup
        int[][] prefixSumLookup = new int[S.length()][NUCLEOTIDE_SIZE];
        prefixSumLookup[0][getIndexOfNucleotide(S.charAt(0))] = 1;
        for (int i = 1; i < S.length(); i++) {
            addImpact(prefixSumLookup[i-1], prefixSumLookup[i], S.charAt(i));
        }
        return findImpacts(prefixSumLookup, S.length(),  P, Q);
    }

    private int[] findImpacts(int[][] prefixSumLookup, int nucleotideCount, int[] P, int[] Q) {
        int queryCount = P.length;
        int[] result = new int[queryCount];
        for (int i = 0; i < queryCount; i++) {
            int start = P[i];
            int end = Q[i];
            validateIntegerPairsInArray(nucleotideCount, start, end);

            result[i] = getImpactOfQuery(prefixSumLookup, start, end);
        }
        return result;
    }
    private int getImpactOfQuery(int[][] prefixSumLookup, int start, int end) {
        if(start == 0) {
            for (int i = 0; i < NUCLEOTIDE_SIZE; i++) {
                if(prefixSumLookup[end][i] > 0)
                    return i+1;
            }
        } else {
            for (int i = 0; i < NUCLEOTIDE_SIZE; i++) {
                if(prefixSumLookup[end][i] - prefixSumLookup[start-1][i] > 0) {
                    return i+1;
                }
            }
        }

        return 0;
    }

    private void addImpact(int[] pre, int[] current, char c) {
        for (int i = 0; i < NUCLEOTIDE_SIZE; i++) {
            current[i] = pre[i];
        }
        int indexToAdd = getIndexOfNucleotide(c);
        current[indexToAdd] = pre[indexToAdd] + 1;
    }

    private int getIndexOfNucleotide(char c) {
        if('A' == c ) {
            return 0;
        } else if('C' == c) {
            return 1;
        } else if('G' == c) {
            return 2;
        } else if('T' == c) {
            return 3;
        } else {
            throw new IllegalArgumentException("Illegal char");
        }
    }
}
