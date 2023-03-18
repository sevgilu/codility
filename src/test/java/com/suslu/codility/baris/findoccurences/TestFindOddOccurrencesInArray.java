package com.suslu.codility.baris.findoccurences;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestFindOddOccurrencesInArray {
    private final FindOddOccurrencesInArray findOddOccurrencesInArray;
    public TestFindOddOccurrencesInArray(FindOddOccurrencesInArray findOddOccurrencesInArray) {
        this.findOddOccurrencesInArray = findOddOccurrencesInArray;
    }

    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> findOddOccurrencesInArray.findOddOccurrences(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    public void shouldRotate(int expected, int[] A) {
        Assertions.assertEquals(expected, findOddOccurrencesInArray.findOddOccurrences(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(0, new int[]{1,2,3,4,5,0,1,2,3,4,5}),
                Arguments.of(0, new int[]{-32,0,-24,-4,-24,-789,-789,-32,-4}),
                Arguments.of(0, new int[]{32,0,24,-4,24,-789,-789,32,-4}),
                Arguments.of(987, new int[]{1,2,3,4,5,987,1,2,3,4,5}),
                Arguments.of(14, new int[]{-32,14,-24,-4,-24,-789,-789,-32,-4}),
                Arguments.of(3, new int[]{32,24,-4,24,-789,3,-789,32,-4}),
                Arguments.of(-1, new int[]{1,2,3,4,5,-1,1,2,3,4,5}),
                Arguments.of(-99, new int[]{-32,-99,-24,-4,-24,-789,-789,-32,-4}),
                Arguments.of(-897, new int[]{32,-897,24,-4,24,-789,-789,32,-4})
        );
    }

    @Test
    void shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedExist3Times(){
        int[] intArray = new int[]{1,32,1,24,-4,24,-789,-789,32,-4,1};
        Assertions.assertEquals(1, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }

}
