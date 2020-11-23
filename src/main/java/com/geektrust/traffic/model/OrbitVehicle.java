package com.geektrust.traffic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

/**
 * This class defines the model for an orbit vehicle.
 * An Orbit vehicle would take certain time to cross a crater
 * on the orbit, it also extends abstract class vehicle.
*/
@EqualsAndHashCode
public class OrbitVehicle extends Vehicle {
    @JsonProperty
    private int timeToCrossCrater;

    public OrbitVehicle() {
        super();
    }

    public OrbitVehicle(String name, int speed, int timeToCrossCrater) {
        super(name, speed);
        this.timeToCrossCrater = timeToCrossCrater;
    }

    /**
     * This method calculates the time for an orbit vehicle to traverse a
     * given orbit.
     * @return int
    */
    public int timeItTakesToTraverseTheOrbit(Orbit orbit) {
        int MINUTES_IN_AN_HOUR = 60;
        int traverseSpeed = 0;
        if (orbit.getTrafficSpeed() < speed) {
            traverseSpeed = orbit.getTrafficSpeed();
        } else {
            traverseSpeed = speed;
        }
        double timeToCoverDistance = (double) orbit.getLength() / (double) traverseSpeed;
        int eta = (int) ((orbit.getNoOfCraters() * timeToCrossCrater) + (timeToCoverDistance * MINUTES_IN_AN_HOUR));
        return eta;
    }
}
