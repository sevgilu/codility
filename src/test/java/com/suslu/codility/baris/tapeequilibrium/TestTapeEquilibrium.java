package com.suslu.codility.baris.tapeequilibrium;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public abstract class TestTapeEquilibrium {

    private final TapeEquilibrium tapeEquilibrium;

    public TestTapeEquilibrium(TapeEquilibrium tapeEquilibrium) {
        this.tapeEquilibrium = tapeEquilibrium;
    }
    @Test
    void shouldThrowException_withNullArray(){
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(null));
    }
    @Test
    void shouldThrowException_withEmptyArray(){
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(new int[]{}));
    }
    @Test
    void shouldThrowException_withSingleElementArray(){
        int[] intArray = new int[]{45};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_whenSizeMoreThan_100000(){
        int[] intArray = IntStream.range(0,100001).toArray();
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueLessThanMinus1000(){
        int[] intArray = new int[]{1,-2,-1001,-1};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueLessThanMinus1000_atFirstElement(){
        int[] intArray = new int[]{-1001,1,2};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueLessThanMinus1000_atLastElement(){
        int[] intArray = new int[]{1,2,-1001};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueMoreThan1000(){
        int[] intArray = new int[]{1,2,1001,3,8};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueMoreThan1000_atFirstElement(){
        int[] intArray = new int[]{1001,1,2,3,8};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }
    @Test
    void shouldThrowException_withArray_havingValueMoreThan1000_atLastElement(){
        int[] intArray = new int[]{1,2,3,8,1001};
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }

    @Test
    void shouldReturnValidResult_withArrayOfPositiveIntegers(){
        int[] intArray = new int[]{3,1,2,4,3};
        Assertions.assertEquals(1, tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }

    @Test
    void shouldReturnValidResult_withArrayOfNegativeIntegers(){
        int[] intArray = new int[]{-3,-1,-2,-4,-3};
        Assertions.assertEquals(1, tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }

    @Test
    void shouldReturnValidResult_withArrayOfMixSignedIntegers(){
        int[] intArray = new int[]{-1000,1,7,-3,1000,3,-6};
        Assertions.assertEquals(8, tapeEquilibrium.findMinimumAbsoluteDifference(intArray));
    }

}
