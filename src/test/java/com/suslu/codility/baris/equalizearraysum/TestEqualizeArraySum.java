package com.suslu.codility.baris.equalizearraysum;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public abstract class TestEqualizeArraySum {

    private final EqualizeArraySum equalizeArraySum;

    public TestEqualizeArraySum(EqualizeArraySum equalizeArraySum) {
        this.equalizeArraySum = equalizeArraySum;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] a, int[] b) {
        Assertions.assertThrows(InvalidInputException.class, () -> equalizeArraySum.isEqualizationPossible(a, b));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, new int[1]),
                Arguments.of(new int[1], null),
                Arguments.of(new int[0], new int[1]),
                Arguments.of(new int[1], new int[0]),
                Arguments.of(new int[0], new int[0]),
                Arguments.of(new int[1], new int[4]),
                Arguments.of(new int[12], new int[10])
        );
    }

    @ParameterizedTest
    @MethodSource("successData")
    public void shouldRotate(boolean expected, int[] a, int[] b) {
        Assertions.assertEquals(expected, equalizeArraySum.isEqualizationPossible(a, b));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(false, new int[]{12,1,5}, new int[]{6,2,9}),
                Arguments.of(true, new int[]{2,9,1}, new int[]{5,3,8}),
                Arguments.of(true, new int[]{3,8,1,2}, new int[]{5,4,7,4}),
                Arguments.of(false, new int[]{3,8,1,2}, new int[]{3,8,1,8})
        );
    }

}
