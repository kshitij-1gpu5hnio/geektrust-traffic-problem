package com.geektrust.traffic.travelmanager;

import com.geektrust.traffic.model.Orbit;
import com.geektrust.traffic.model.OrbitVehicle;
import com.geektrust.traffic.model.TravelOption;
import com.geektrust.traffic.model.WeatherCondition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the the method defined in the TravelManager
 * interface.
*/
public class TravelManagerImpl implements TravelManager {

    /**
     * Default constructor for TravelManagerImpl.
    */
    public TravelManagerImpl() {
    }

    /**
     * This method gives the best travel option based on the weather, vehicles available and possible routes.
     * @return A TravelOption object.
    */
    public TravelOption getBestTravelOption(WeatherCondition weatherCondition,
        OrbitVehicle[] vehicles, Orbit[] orbits) {
        List<OrbitVehicle> suitableVehicles = weatherCondition
            .pickSuitableVehicles(Arrays.asList(vehicles));
        ArrayList<TravelOption> travelOptions = new ArrayList<TravelOption>();
        for (Orbit orbit : orbits) {
            Map.Entry<String, Integer> bestVehicleForOrbit =
            fastestVehicleOnOrbit(weatherCondition, suitableVehicles, orbit);
            travelOptions.add(new TravelOption(bestVehicleForOrbit.getKey(), orbit.getName(), bestVehicleForOrbit.getValue()));
        }
        Comparator<TravelOption> timeToTraverseComparator = Comparator.comparingInt(TravelOption::getTimeToTraverseOrbit);
        travelOptions.sort(timeToTraverseComparator);
        return travelOptions.get(0);
    }

    private Map.Entry<String, Integer> fastestVehicleOnOrbit(WeatherCondition weatherCondition,
        List<OrbitVehicle> vehicles, Orbit orbit) {
        Map<String, Integer> vehicleAndTimeItTakeToTraverseTheOrbit = getVehicleAndTimeItTakeToTraverseTheOrbit(vehicles,
            weatherCondition.getEffectOnRouteByPercentage(), orbit);
        return vehicleAndTimeItTakeToTraverseTheOrbit.entrySet().stream().min(Map.Entry.comparingByValue()).get();
    }

    private Map<String, Integer> getVehicleAndTimeItTakeToTraverseTheOrbit(List<OrbitVehicle> vehicles, double effectOnRouteByPercentage,
            Orbit orbit) {
        Map<String, Integer> vehicleAndTimeItTakeToTraverseTheOrbit = new HashMap<String, Integer>();
        orbit.updateNoOfCraters(effectOnRouteByPercentage);
        for (OrbitVehicle vehicle : vehicles) {
            vehicleAndTimeItTakeToTraverseTheOrbit.put(vehicle.getName(), vehicle.timeItTakesToTraverseTheOrbit(orbit));
        }
        return vehicleAndTimeItTakeToTraverseTheOrbit;
    }
}
