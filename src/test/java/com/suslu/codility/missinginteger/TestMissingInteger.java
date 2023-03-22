package com.suslu.codility.missinginteger;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestMissingInteger {

    private final MissingInteger missingInteger;

    public TestMissingInteger(MissingInteger missingInteger) {
        this.missingInteger = missingInteger;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> missingInteger.findMinimumMissingPositiveInteger(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[0]),
                Arguments.of(new int[100001]),
                Arguments.of(new int[]{-1000001,3}),
                Arguments.of(new int[]{1000001,3})
        );
    }
    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindMinimumMissingInteger(int expected, int[] A) {
        Assertions.assertEquals(expected, missingInteger.findMinimumMissingPositiveInteger(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(1, new int[]{0}),
                Arguments.of(1, new int[]{-1,3}),
                Arguments.of(2, new int[]{1,3}),
                Arguments.of(4, new int[]{1,2,3}),
                Arguments.of(5, new int[]{1,3,6,4,1,2}),
                Arguments.of(3, new int[]{-4,0,1,2})
        );
    }
}
