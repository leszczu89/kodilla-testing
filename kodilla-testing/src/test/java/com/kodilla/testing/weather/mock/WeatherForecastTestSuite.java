package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
    private static int counter = 0;
    @BeforeEach
    public void before(){
        counter++;
        System.out.println("Test number: " + counter);
    }
    @AfterEach
    public void after(){
        System.out.println("Test completed");
    }
    @Mock
    private Temperatures temperaturesMock;
    @Test
    void testCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    void testAverageTemperature(){
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Poznan", 20.5);
        temperaturesMap.put("Zakopane", 27.2);
        temperaturesMap.put("Sopot", 30.0);
        temperaturesMap.put("Gdynia", 22.2);
        temperaturesMap.put("Gdansk", 21.8);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double averageTest = (20.5 + 27.2 + 30.0 + 22.2 + 21.8)/5;
        //Then
        Assertions.assertEquals(averageTest, weatherForecast.averageTemperature());
    }
    @Test
    void testMedianTemperatures(){
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Warszawa", 24.5);
        temperaturesMap.put("Zakopane", 22.5);
        temperaturesMap.put("Bialystok", 30.0);
        temperaturesMap.put("Wroclaw", 21.8);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        double medianTest = (22.5+24.5)/2.0;
        //Then
        Assertions.assertEquals(medianTest, weatherForecast.medianTemperatures());

    }
}
