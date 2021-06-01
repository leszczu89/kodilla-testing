package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(1.5, 1.5);
        } catch (Exception e) {
            System.out.println("There occurred exception e: " + e);
        } finally {
            System.out.println("The end of the program.");
        }
    }
}
