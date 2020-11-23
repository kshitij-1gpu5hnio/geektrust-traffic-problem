package com.geektrust.traffic.travelmanager;

import com.geektrust.traffic.model.Orbit;
import com.geektrust.traffic.model.OrbitVehicle;
import com.geektrust.traffic.model.TravelOption;
import com.geektrust.traffic.model.WeatherCondition;

/**
 * This Interface defines the methods to be implemented by the different
 * implementation classes.
*/
public interface TravelManager {

    TravelOption getBestTravelOption(WeatherCondition weatherCondition, OrbitVehicle[] vehicles,
            Orbit[] orbits);
}
