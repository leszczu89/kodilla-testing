package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {
        String string = "This is a beautiful day";
        String string2 = "Hello World";
        String string3 = "This strings length is: ";
        String string4 = "This fragment won't be shown, This string is a substring of a string.";
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify(string, String::toUpperCase));
        System.out.println(poemBeautifier.beautify(string2, stringTest -> stringTest + " ABC"));
        System.out.println(poemBeautifier.beautify(string3, stringTest -> stringTest + stringTest.length()));
        System.out.println(poemBeautifier.beautify(string4, stringTest -> stringTest.substring(30)));
    }
}
