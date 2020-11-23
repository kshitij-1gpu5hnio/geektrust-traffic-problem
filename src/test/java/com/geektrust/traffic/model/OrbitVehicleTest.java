package com.geektrust.traffic.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrbitVehicleTest {
    private Orbit orbit;
    private OrbitVehicle vehicle;

    @Before
    public void init() {
        orbit = new Orbit("ORBIT1", "Silk Dorb", "Hallitharam", 18, 20, 12);
        vehicle = new OrbitVehicle("bike", 10, 2);
    }

    @Test
    public void testTimeItTakesToTraverseTheOrbit() {
        int actualResult = vehicle.timeItTakesToTraverseTheOrbit(orbit);
        assertEquals(148, actualResult);
    }
}
