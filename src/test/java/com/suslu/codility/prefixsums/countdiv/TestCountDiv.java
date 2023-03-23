package com.suslu.codility.prefixsums.countdiv;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestCountDiv {
    private final CountDiv countDiv;
    public TestCountDiv(CountDiv countDiv) {
        this.countDiv = countDiv;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int A, int B, int K) {
        Assertions.assertThrows(InvalidInputException.class, () -> countDiv.findDivisibleCount(A, B, K));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(-1, 1, 1),
                Arguments.of((CountDiv.LIMIT +1), 1, 1),
                Arguments.of(1, -1, 1),
                Arguments.of(1, (CountDiv.LIMIT +1), 1),
                Arguments.of(1, 1, 0),
                Arguments.of(1, 1, (CountDiv.LIMIT +1)),
                Arguments.of(3, 1, 1)
        );
    }
    @ParameterizedTest
    @MethodSource("successData")
    public void shouldfindDivisibleCount(int expected, int A, int B, int K) {
        Assertions.assertEquals(expected, countDiv.findDivisibleCount(A, B, K));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(1, 0,0,1),
                Arguments.of(1, 1,1,1),
                Arguments.of(2, 1,2,1),
                Arguments.of(1, 1,2,2),
                Arguments.of(3, 6,11,2),
                Arguments.of(7, 23,55,5),
                Arguments.of(7, 23,59,5)
        );
    }
}
