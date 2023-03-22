package com.suslu.codility.binarygap;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestBinaryGap {

    private final BinaryGap binaryGap;

    public TestBinaryGap(BinaryGap binaryGap) {
        this.binaryGap = binaryGap;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    void shouldThrowException(int N) {
        Assertions.assertThrows(InvalidInputException.class,() -> binaryGap.findLongestBinaryGap(N));
    }
    static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(0)
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    void shouldCalculateMaxCounters(int N, int expected) {
        int actual = binaryGap.findLongestBinaryGap(N);
        Assertions.assertEquals(expected, actual);
    }
    static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(9, 2),
                Arguments.of(529, 4),
                Arguments.of(20, 1),
                Arguments.of(15, 0),
                Arguments.of(32, 0),
                Arguments.of(1041, 5),
                Arguments.of(1610612737, 28)
        );
    }
}
