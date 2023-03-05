package com.suslu.codility;

import com.suslu.codility.exception.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestFindOddOccurrencesInArraySolution1 {

    FindOddOccurrencesInArray solution = new FindOddOccurrencesInArray();
    @Test
    void solution1_shouldThrowException_withNullArrayAsInput(){
        Assertions.assertThrows(InvalidInputException.class, () -> solution.solution1(null));
    }
    @Test
    void solution1_shouldThrowException_withEmptyArrayAsInput(){
        Assertions.assertThrows(InvalidInputException.class, () -> solution.solution1(null));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{1,2,3,4,5,0,1,2,3,4,5};
        Assertions.assertEquals(0, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{-32,0,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(0, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsZero(){
        int[] intArray = new int[]{32,0,24,-4,24,-789,-789,32,-4};
        Assertions.assertEquals(0, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{1,2,3,4,5,987,1,2,3,4,5};
        Assertions.assertEquals(987, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{-32,14,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(14, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsPositive(){
        int[] intArray = new int[]{32,24,-4,24,-789,3,-789,32,-4};
        Assertions.assertEquals(3, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfPositiveNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{1,2,3,4,5,-1,1,2,3,4,5};
        Assertions.assertEquals(-1, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfNegativeNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{-32,-99,-24,-4,-24,-789,-789,-32,-4};
        Assertions.assertEquals(-99, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedIsNegative(){
        int[] intArray = new int[]{32,-897,24,-4,24,-789,-789,32,-4};
        Assertions.assertEquals(-897, solution.solution1(intArray));
    }
    @Test
    void solution1_shouldReturnUnpairedNumber_withArrayOfMixedNumbers_whenUnpairedExist3Times(){
        int[] intArray = new int[]{1,32,1,24,-4,24,-789,-789,32,-4,1};
        Assertions.assertEquals(1, solution.solution1(intArray));
    }

}
