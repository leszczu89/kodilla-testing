package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Testing OddNumbersExterminator begins");
    }
    @AfterEach
    public void after(){
        System.out.println("Testing OddNumbersExterminator ends");
    }
    @DisplayName("When we check empty list, \n" +
            "then exterminator should return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        List<Integer> emptyList = new LinkedList<>();
        System.out.println("Testing empty list");
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = exterminator.exterminate(emptyList);
        //Then
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("When we check list with odd and even numbers, \n" +
            "then exterminator should return list with even numbers")
    @Test
    void testOddNumbersExterminatorNormalList(){
        Integer[] checkedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> normalList = Arrays.asList(checkedArray);
        Integer[] evenArray = new Integer[]{2, 4, 6, 8, 10};
        List<Integer> evenList = Arrays.asList(evenArray);
        System.out.println("Testing list :" + normalList);
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        //When
        List<Integer> result = exterminator.exterminate(normalList);
        //Then
        Assertions.assertEquals(evenList, result);
    }
}
