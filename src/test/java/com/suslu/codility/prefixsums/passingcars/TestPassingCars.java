package com.suslu.codility.prefixsums.passingcars;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestPassingCars {

    private final PassingCars passingCars;

    public TestPassingCars(PassingCars passingCars) {
        this.passingCars = passingCars;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> passingCars.findPassingCarCount(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new int[0]),
                Arguments.of(new int[100001]),
                Arguments.of(new int[]{1,0,1,2}),
                Arguments.of(new int[]{-1})
        );
    }
    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindPassingCarCount(int expected, int[] A) {
        Assertions.assertEquals(expected, passingCars.findPassingCarCount(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(5, new int[]{0,1,0,1,1}),
                Arguments.of(0, new int[]{1}),
                Arguments.of(0, new int[]{0}),
                Arguments.of(1, new int[]{0,1}),
                Arguments.of(0, new int[]{1,0}),
                Arguments.of(0, new int[]{0,0,0,0}),
                Arguments.of(0, new int[]{1,1,1,1}),
                Arguments.of(3, new int[]{0,0,0,1}),
                Arguments.of(1, new int[]{1,1,1,0,1}),
                Arguments.of(2, new int[]{1,0,0,1}),
                Arguments.of(4, new int[]{0,1,1,1,1,0})
        );
    }
}
