package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }
    public double averageTemperature(){
        Double sum = 0.0;
        int counter = 0;
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()){
            sum+=temperature.getValue();
            counter++;
        }
        double average = sum/counter;
        return average;
    }
    public double medianTemperatures(){
        double median = 0.0;
        double[] temperatureArray = new double[temperatures.getTemperatures().size()];
        int i = 0;
        for (Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            temperatureArray[i] = temperature.getValue();
            i++;
        }
        Arrays.sort(temperatureArray);
        if (temperatureArray.length%2==0){
            median = (temperatureArray[temperatureArray.length/2] + temperatureArray[temperatureArray.length/2 - 1])/2.0;
        } else {
            median = temperatureArray[(temperatureArray.length -1)/2];
        }
        return median;
    }
}
