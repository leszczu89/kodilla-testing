package com.kodilla.exception.main;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightSearchEngine;
import com.kodilla.exception.test.RouteNotFoundException;


public class ExceptionModuleRunner {

    public static void main(String[] args) {
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try {
            flightSearchEngine.findFlight(new Flight("Wrocław", "Kraków"));
        } catch (RouteNotFoundException e) {
            System.out.println("Given flight does not exist");
        }
    }
}
