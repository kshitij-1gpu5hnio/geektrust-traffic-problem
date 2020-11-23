package com.geektrust.traffic.travel;

import org.junit.Before;
import org.junit.Test;
import com.geektrust.traffic.enums.Weather;
import com.geektrust.traffic.model.Orbit;
import com.geektrust.traffic.model.OrbitVehicle;
import com.geektrust.traffic.model.TravelOption;
import com.geektrust.traffic.model.WeatherCondition;
import com.geektrust.traffic.travelmanager.TravelManagerImpl;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * This class includes tests for TravelManager class.
 */
public class TravelManagerTest {

    private OrbitVehicle[] vehicles = new OrbitVehicle[3];
    private Orbit[] orbits = new Orbit[2];
    private TravelManagerImpl travelManager;

    @Before
    public void init() {
        vehicles[0] = new OrbitVehicle("bike", 10, 2);
        vehicles[1] = new OrbitVehicle("tuktuk", 12, 1);
        vehicles[2] = new OrbitVehicle("car", 20, 3);
        orbits[0] = new Orbit("ORBIT1", "Silk Dorb", "Hallitharam", 18, 20, 12);
        orbits[1] = new Orbit("ORBIT2", "Silk Dorb", "Hallitharam", 20, 10, 10);
        travelManager = new TravelManagerImpl();
    }

    @Test
    public void testGetBestTravelOptionWhenWeatherIsSunny() {
        List<String> vehicleList = new ArrayList<String>();
        vehicleList.add("bike");
        vehicleList.add("tuktuk");
        vehicleList.add("car");
        TravelOption actualtravelOption = travelManager.getBestTravelOption(new WeatherCondition(Weather.valueOf("SUNNY"),
            vehicleList, -10.0), vehicles, orbits);
        TravelOption expectedTravelOption = new TravelOption("tuktuk", "ORBIT1", 108);
        assertEquals(expectedTravelOption, actualtravelOption);
    }

    @Test
    public void testGetBestTravelOptionWhenWeatherIsRainy() {
        List<String> vehicleList = new ArrayList<String>();
        vehicleList.add("tuktuk");
        vehicleList.add("car");
        TravelOption actualtravelOption = travelManager.getBestTravelOption(new WeatherCondition(Weather.valueOf("RAINY"),
            vehicleList, 20.0), vehicles, orbits);
        TravelOption expectedTravelOption = new TravelOption("tuktuk", "ORBIT1", 114);
        assertEquals(expectedTravelOption, actualtravelOption);
    }

    @Test
    public void testGetBestTravelOptionWhenWeatherIsWindy() {
        List<String> vehicleList = new ArrayList<String>();
        vehicleList.add("bike");
        vehicleList.add("car");
        TravelOption actualtravelOption = travelManager.getBestTravelOption(new WeatherCondition(Weather.valueOf("WINDY"),
            vehicleList, 0.0), vehicles, orbits);
        TravelOption expectedTravelOption = new TravelOption("bike", "ORBIT2", 140);
        assertEquals(expectedTravelOption, actualtravelOption);
    }
}
