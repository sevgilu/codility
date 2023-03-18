package com.suslu.codility.baris.maxcounter;

public class MaxCounterSolution2 implements MaxCounter {
    @Override
    public int[] calculateMaxCounters(int N, int[] A) {
        validateInput(N, A);
        int[] counters = new int[N];
        int counterLimit = N+1;
        int max = 0;
        int maxSnapshot=0;

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            validateInput(N, value);
            if( 1 <= value && value <= N) {
                int index = value - 1;
                int count = counters[index];
                count = (count == 0) ? maxSnapshot : count;
                int newCount =  count + 1;
                counters[index] = newCount;
                if(max < newCount) {
                    max = newCount;
                }
            } else if( value == counterLimit) {
                counters = new int[N];
                maxSnapshot = max;
            }
        }

        for (int i = 0; i < N; i++) {
            if(counters[i] == 0)
                counters[i] = maxSnapshot;
        }

        return counters;
    }
}
