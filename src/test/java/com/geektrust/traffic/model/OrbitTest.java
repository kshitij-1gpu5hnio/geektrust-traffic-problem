package com.geektrust.traffic.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrbitTest {
    private Orbit orbit;

    @Before
    public void init() {
        orbit = new Orbit("ORBIT1", "Silk Dorb", "Hallitharam", 18, 20, 12);
    }

    @Test
    public void testUpdateNoOfCraters() {
        orbit.updateNoOfCraters(20.0);
        assertEquals(24, orbit.getNoOfCraters());
    }
}
