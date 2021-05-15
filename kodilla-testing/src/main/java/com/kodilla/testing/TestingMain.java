package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;
public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        Calculator myCalculator = new Calculator();
        int addResult = myCalculator.add(4,5);

        if (addResult==(4+5)){
            System.out.println("Addition correct");
        } else {
            System.out.println("Addition is not correct");
        }

        int subtractResult = myCalculator.subtract(5,4);

        if (subtractResult==(5-4)){
            System.out.println("Subtraction correct");
        } else {
            System.out.println("Subtraction is not correct");
        }
    }
}
