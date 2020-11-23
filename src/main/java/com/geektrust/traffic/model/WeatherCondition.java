package com.geektrust.traffic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.geektrust.traffic.enums.Weather;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 * This class defines a model of weather condition which has a weather and
 * a list of names of vehicles suitable in the weather condition, this class
 * extends travel condition abstract class.
*/

public class WeatherCondition extends TravelCondition {
    @Getter
    private Weather weather;
    @JsonProperty
    private List<String> suitableVehiclesForWeather;

    public WeatherCondition() {
        super();
    }

    /**
     * Constructor for weather condition class.
    */
    public WeatherCondition(Weather weather, List<String> suitableVehiclesForWeather, double effectOnRouteByPercentage) {
        super(effectOnRouteByPercentage);
        this.weather = weather;
        this.suitableVehiclesForWeather = suitableVehiclesForWeather;
    }

    /**
     * This method selects a list of OrbitVehicle based on the suitable
     * vehicles for the weather condition.
     * @return List<OrbitVehicle>
    */
    public List<OrbitVehicle> pickSuitableVehicles(List<OrbitVehicle> vehicles) {
        List<OrbitVehicle> selectedVehicles = new ArrayList<OrbitVehicle>();
        selectedVehicles = vehicles.stream().filter(vehicle -> suitableVehiclesForWeather.contains(vehicle.getName().toLowerCase()))
        .collect(Collectors.toList());

        return selectedVehicles;
    }
}
