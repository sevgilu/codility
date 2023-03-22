package com.suslu.codility.timecomplexity.tapeequilibrium;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class TestTapeEquilibrium {

    private final TapeEquilibrium tapeEquilibrium;

    public TestTapeEquilibrium(TapeEquilibrium tapeEquilibrium) {
        this.tapeEquilibrium = tapeEquilibrium;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> tapeEquilibrium.findMinimumAbsoluteDifference(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[0]),
                Arguments.of(new int[]{45}),
                Arguments.of(IntStream.range(0,100001).toArray()),
                Arguments.of(new int[]{1,-2,-1001,-1}),
                Arguments.of(new int[]{-1001,1,2}),
                Arguments.of(new int[]{1,2,-1001}),
                Arguments.of(new int[]{1,2,1001,3,8}),
                Arguments.of(new int[]{1001,1,2,3,8}),
                Arguments.of(new int[]{1,2,3,8,1001})
        );
    }
    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindMinimumAbsoluteDifference(int expected, int[] A) {
        Assertions.assertEquals(expected, tapeEquilibrium.findMinimumAbsoluteDifference(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(1,  new int[]{3,1,2,4,3}),
                Arguments.of(1,  new int[]{-3,-1,-2,-4,-3}),
                Arguments.of(8,  new int[]{-1000,1,7,-3,1000,3,-6})
        );
    }
}
