package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String string, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(string);
        return result;
    }
}
