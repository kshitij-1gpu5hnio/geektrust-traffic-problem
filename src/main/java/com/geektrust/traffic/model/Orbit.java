package com.geektrust.traffic.model;


import lombok.Getter;
import lombok.Setter;

/**
 * This class defines the model for an orbit.
 * An orbit will have some number of craters in it and
 * a current traffic speed, this also extends abstract
 * class route.
*/
public class Orbit extends Route {
    @Getter
    private int noOfCraters;
    @Getter
    @Setter
    private int trafficSpeed;

    public Orbit() {
        super();
    }

    /**
     * Constructor for orbit class.
    */
    public Orbit(String name, String source, String destination, int length, int noOfCraters, int trafficSpeed) {
        super(name, source, destination, length);
        this.noOfCraters = noOfCraters;
        this.trafficSpeed = trafficSpeed;
    }

    /**
     * This medthod updates the no of craters on the orbit based
     * on the percentage of effect of weahter on orbit.
    */
    public void updateNoOfCraters(double effectOfWeatherOnCraters) {
        double HUNDRED = 100.0;
        this.noOfCraters = this.noOfCraters
                + ((int) (noOfCraters * effectOfWeatherOnCraters / HUNDRED));
    }

    /**
     * This method updates the traffic speed for the orbit. 
    */
    public void updateTrafficSpeed(int trafficSpeed) {
        this.trafficSpeed = trafficSpeed;
    }
}
