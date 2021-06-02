package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public void findFlight (Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Gdańsk", true);
        flightMap.put("Warszawa", true);
        flightMap.put("Kraków", false);

        if (flightMap.containsKey(flight.getArrivalAirport())){
            System.out.println("You can land on the airport: " + flight.getArrivalAirport() + " : "
                    + flightMap.get(flight.getArrivalAirport()));
        } else {
            throw new RouteNotFoundException();
        }
    }
}
