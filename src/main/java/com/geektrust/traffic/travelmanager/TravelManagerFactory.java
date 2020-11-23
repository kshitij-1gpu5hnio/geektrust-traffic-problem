package com.geektrust.traffic.travelmanager;

/**
 * This class creates an instance of travelManager interface implementation
 * and returns it.
*/
public class TravelManagerFactory {

    protected TravelManagerFactory() {
    }

    public static TravelManager getTravelManager() {
        TravelManager travelManager = new TravelManagerImpl();
        return travelManager;
    }
}
