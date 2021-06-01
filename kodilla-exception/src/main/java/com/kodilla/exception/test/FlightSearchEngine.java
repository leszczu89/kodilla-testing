package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {

    public void findFlight (Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Gdańsk", true);
        flightMap.put("Warszawa", true);
        flightMap.put("Kraków", false);

        String message = "";
        for (Map.Entry<String, Boolean> entry : flightMap.entrySet()){
            if (entry.getKey().equals(flight.getArrivalAirport())){
                message = "You can land on the airport: " + flight.getArrivalAirport() + " : " + entry.getValue();
            }
        }
        if(!message.equals("")) {
            System.out.println(message);
        } else {
            throw new RouteNotFoundException();
        }
    }
}
