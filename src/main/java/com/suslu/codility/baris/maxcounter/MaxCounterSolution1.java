package com.suslu.codility.baris.maxcounter;

public class MaxCounterSolution1 implements MaxCounter {
    @Override
    public int[] calculateMaxCounters(int N, int[] A) {
        validateInput(N, A);
        int[] counters = new int[N];
        int counterLimit = N+1;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            validateInput(N, value);

            if( 1 <= value && value <= N) {
                int index = value - 1;
                int newCount =  counters[index] + 1;
                counters[index] = newCount;
                if(max < newCount) {
                    max = newCount;
                }
            } else if( value == counterLimit) {
                for (int j = 0; j < N; j++) {
                    counters[j] = max;
                }
            }
        }

        return counters;
    }
}
