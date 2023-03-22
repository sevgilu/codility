package com.suslu.codility.iterations.binarygap;

public class BinaryGapSolution1 implements BinaryGap {

    @Override
    public int findLongestBinaryGap(int N) {
        validateInput(N);
        char[] binary = Integer.toBinaryString(N).toCharArray();
        boolean previousIsOne = false;
        int max = 0;
        int count = 0;

        for (char c: binary) {
            if('1' == c){
                previousIsOne = true;
                if(max < count) {
                    max = count;
                }
                count = 0;
            } else {
                previousIsOne = false;
                count++;
            }
        }
        return max;
    }


}
