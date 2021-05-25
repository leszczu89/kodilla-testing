package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] array = {1, 3, 3, 4, 5, 6, 7, 8, 9, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 200};
        //When
        double result = ArrayOperations.getAverage(array);
        double testResult = 481.0/20.0;
        //Then
        assertEquals(testResult, result);
    }
}
