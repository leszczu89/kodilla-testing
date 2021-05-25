package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity () {
        //Given
        Country china = new Country(BigDecimal.valueOf(456977444));
        Country southKorea = new Country(BigDecimal.valueOf(45562133));
        Country northKorea = new Country(BigDecimal.valueOf(632589));
        Continent asia = new Continent();
        asia.addCountry(china);
        asia.addCountry(southKorea);
        asia.addCountry(northKorea);
        Country poland = new Country(BigDecimal.valueOf(30256948));
        Country germany = new Country(BigDecimal.valueOf(64985115));
        Country france = new Country(BigDecimal.valueOf(8941613));
        Continent europe = new Continent();
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);
        Country nigeria = new Country(BigDecimal.valueOf(659494));
        Country uganda = new Country(BigDecimal.valueOf(321566));
        Country senegal = new Country(BigDecimal.valueOf(669452));
        Continent africa = new Continent();
        africa.addCountry(nigeria);
        africa.addCountry(uganda);
        africa.addCountry(senegal);
        World world = new World();
        world.addContinent(africa);
        world.addContinent(asia);
        world.addContinent(europe);

        //When
        BigDecimal testSum = new BigDecimal("609006354");
        BigDecimal result = world.getPeopleQuantity();
        //Then
        Assertions.assertEquals(testSum, result);
    }
}
