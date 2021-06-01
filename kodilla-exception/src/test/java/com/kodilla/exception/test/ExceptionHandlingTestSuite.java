package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTestSuite {

    @Test
    void testWithCorrectValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 2.0));
    }

    @Test
    void testYValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.6)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.4))
        );
    }

    @Test
    void testXValues() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.1, 2.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 2.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 2.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 3.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.9, 4.0))
        );
    }


}
