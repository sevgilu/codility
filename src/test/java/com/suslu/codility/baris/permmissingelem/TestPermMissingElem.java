package com.suslu.codility.baris.permmissingelem;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class TestPermMissingElem {

    private final PermMissingElem permMissingElem;

    public TestPermMissingElem(PermMissingElem permMissingElem) {
        this.permMissingElem = permMissingElem;
    }
    @ParameterizedTest
    @MethodSource("exceptionData")
    public void shouldThrowException(int[] A) {
        Assertions.assertThrows(InvalidInputException.class, () -> permMissingElem.findMissingElement(A));
    }
    private static Stream<Arguments> exceptionData() {
        return Stream.of(
                Arguments.of(null, null)
        );
    }
    @ParameterizedTest
    @MethodSource("successData")
    public void shouldFindMissingElement(int expected, int[] A) {
        Assertions.assertEquals(expected, permMissingElem.findMissingElement(A));
    }
    private static Stream<Arguments> successData() {
        return Stream.of(
                Arguments.of(1, new int[]{}),
                Arguments.of(4, new int[]{2,3,1,5}),
                Arguments.of(2, new int[]{1}),
                Arguments.of(1, new int[]{2}),
                Arguments.of(1, new int[]{5,3,2,4}),
                Arguments.of(5, new int[]{4,3,1,2})
        );
    }

    @Test
    void shouldReturnMissingElement_withValidArray_(){
        int elementCount = 100;
        int randomIndex = RandomGenerator.getDefault().nextInt(elementCount);
        int[] intArray = IntStream.range(1,elementCount)
//                .boxed()
//                .collect(Collectors.toList())
                .toArray();
        int missingValue = intArray[randomIndex];
        intArray[randomIndex] = elementCount;
        Assertions.assertEquals(missingValue, permMissingElem.findMissingElement(intArray));
    }

}
