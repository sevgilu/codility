package com.suslu.codility.baris.permMissingElem;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public abstract class TestPermMissingElem {

    private final PermMissingElem permMissingElem;

    public TestPermMissingElem(PermMissingElem permMissingElem) {
        this.permMissingElem = permMissingElem;
    }
    @Test
    void shouldThrowException_withNullArray(){
        Assertions.assertThrows(InvalidInputException.class, () -> permMissingElem.findMissingElement(null));
    }
    @Test
    void shouldReturnMissingElement_AsOne_withEmptyArray(){
        int[] intArray = new int[]{};
        Assertions.assertEquals(1, permMissingElem.findMissingElement(intArray));
    }
    @Test
    void shouldReturnMissingElement_withValidArray(){
        int[] intArray = new int[]{2,3,1,5};
        Assertions.assertEquals(4, permMissingElem.findMissingElement(intArray));
    }
    @Test
    void shouldReturnMissingElement_withSingleElementArray_whenElementIs_1(){
        int[] intArray = new int[]{1};
        Assertions.assertEquals(2, permMissingElem.findMissingElement(intArray));
    }
    @Test
    void shouldReturnMissingElement_withSingleElementArray_whenElementIs_2(){
        int[] intArray = new int[]{2};
        Assertions.assertEquals(1, permMissingElem.findMissingElement(intArray));
    }
    @Test
    void shouldReturnMissingElement_withValidArray_whenFirstElementMissing(){
        int[] intArray = new int[]{5,3,2,4};
        Assertions.assertEquals(1, permMissingElem.findMissingElement(intArray));
    }
    @Test
    void shouldReturnMissingElement_withValidArray_whenLastElementMissing(){
        int[] intArray = new int[]{4,3,1,2};
        Assertions.assertEquals(5, permMissingElem.findMissingElement(intArray));
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

        System.out.println(missingValue);
        Arrays.stream(intArray).forEach(value -> System.out.print(value+"-"));
        System.out.println();
    }

}
