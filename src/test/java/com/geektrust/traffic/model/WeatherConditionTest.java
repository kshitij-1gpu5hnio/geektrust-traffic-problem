package com.geektrust.traffic.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.geektrust.traffic.enums.Weather;
import static org.junit.Assert.assertEquals;

public class WeatherConditionTest {
    private WeatherCondition weatherCondition;
    private List<String> vehicleListForWeather = new ArrayList<String>();
    private List<OrbitVehicle> vehiclesAvailable = new ArrayList<>();
    private List<OrbitVehicle> expectedListOfVehicles = new ArrayList<>();

    @Before
    public void init() {
        vehiclesAvailable.add(new OrbitVehicle("bike", 10, 2));
        vehiclesAvailable.add(new OrbitVehicle("tuktuk", 12, 1));
        vehiclesAvailable.add(new OrbitVehicle("car", 20, 3));
        vehicleListForWeather.add("tuktuk");
        vehicleListForWeather.add("car");
        weatherCondition = new WeatherCondition(Weather.valueOf("RAINY"), vehicleListForWeather, 20.0);
    }

    @Test
    public void testPickSuitableVehicles() {
        expectedListOfVehicles.add(new OrbitVehicle("tuktuk", 12, 1));
        expectedListOfVehicles.add(new OrbitVehicle("car", 20, 3));

        List<OrbitVehicle> actualListOfVehicles = weatherCondition.pickSuitableVehicles(vehiclesAvailable);

        assertEquals(expectedListOfVehicles, actualListOfVehicles);
    }
}
