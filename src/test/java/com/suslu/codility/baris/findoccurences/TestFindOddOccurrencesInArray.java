package com.suslu.codility.baris.findoccurences;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class TestFindOddOccurrencesInArray {
    private final FindOddOccurrencesInArray findOddOccurrencesInArray;
    public TestFindOddOccurrencesInArray(FindOddOccurrencesInArray findOddOccurrencesInArray) {
        this.findOddOccurrencesInArray = findOddOccurrencesInArray;
    }
    @Test
    void shouldThrowException_withNullArrayAsInput(){
        Assertions.assertThrows(InvalidInputException.class, () -> findOddOccurrencesInArray.findOddOccurrences(null));
    }
    @Test
    void shouldThrowException_withEmptyArrayAsInput(){
        Assertions.assertThrows(InvalidInputException.class, () -> findOddOccurrencesInArray.findOddOccurrences(new int[]{}));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{1,2,3,4,5,0,1,2,3,4,5};
        Assertions.assertEquals(0, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{-32,0,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(0, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{32,0,24,-4,24,-789,-789,32,-4};
        Assertions.assertEquals(0, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{1,2,3,4,5,987,1,2,3,4,5};
        Assertions.assertEquals(987, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{-32,14,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(14, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{32,24,-4,24,-789,3,-789,32,-4};
        Assertions.assertEquals(3, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{1,2,3,4,5,-1,1,2,3,4,5};
        Assertions.assertEquals(-1, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{-32,-99,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(-99, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{32,-897,24,-4,24,-789,-789,32,-4};
        Assertions.assertEquals(-897, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }
    @Test
    void shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedExist3Times(){
        int[] intArray = new int[]{1,32,1,24,-4,24,-789,-789,32,-4,1};
        Assertions.assertEquals(1, findOddOccurrencesInArray.findOddOccurrences(intArray));
    }

}
