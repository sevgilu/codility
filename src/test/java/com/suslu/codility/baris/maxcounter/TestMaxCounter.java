package com.suslu.codility.baris.maxcounter;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TestMaxCounter {
    private final MaxCounter maxCounter;

    public TestMaxCounter(MaxCounter maxCounter) {
        this.maxCounter = maxCounter;
    }

    @ParameterizedTest
    @MethodSource("exceptionData")
    void shouldThrowException(int N, int[] A) {
        Assertions.assertThrows(InvalidInputException.class,() -> maxCounter.calculateMaxCounters(N, A));
    }
    static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(-1, new int[1]),
                Arguments.of(0, new int[1]),
                Arguments.of(1, new int[0]),
                Arguments.of(3, new int[1]),
                Arguments.of(100001, new int[1]),
                Arguments.of(1, new int[100001])
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    void shouldCalculateMaxCounters(int N, int[] A, List<Integer> expected) {
        int[] actual = maxCounter.calculateMaxCounters(N, A);
        List<Integer> actualList= Arrays.stream(actual).boxed().collect(Collectors.toList());
        Assertions.assertEquals(expected.toString(), actualList.toString());
    }
    static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(5, new int[]{3,4,4,6,1,4,4}, Arrays.asList(3,2,2,4,2))
        );
    }
}
