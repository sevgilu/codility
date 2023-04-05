package com.suslu.codility.prefixsums.minavgtwoslice;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestMinAverageTwoSlice {

    private final MinAverageTwoSlice minAverageTwoSlice;

    public TestMinAverageTwoSlice(MinAverageTwoSlice minAverageTwoSlice) {
        this.minAverageTwoSlice = minAverageTwoSlice;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> minAverageTwoSlice.findMinimumAverage(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[0]),
                Arguments.of(new int[1]),
                Arguments.of(new int[100001]),
                Arguments.of(new int[]{-10001,2,3}),
                Arguments.of(new int[]{2,3,10001})
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindMinimalImpacts(int[] A, int expected) {
        Assertions.assertEquals(expected, minAverageTwoSlice.findMinimumAverage(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4}, 0),
                Arguments.of(new int[]{1,3,4}, 0),
                Arguments.of(new int[]{1,0,0}, 1),
                Arguments.of(new int[]{4,2,2,5,1,5,8}, 1),
                Arguments.of(new int[]{3,2,1,-1}, 2),
                Arguments.of(new int[]{1,-1,-3}, 1),
                Arguments.of(new int[]{5, 6, 3, 4, 9},2)
        );
    }
}
