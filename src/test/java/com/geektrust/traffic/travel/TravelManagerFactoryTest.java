package com.geektrust.traffic.travel;

import com.geektrust.traffic.travelmanager.TravelManagerFactory;
import com.geektrust.traffic.travelmanager.TravelManagerImpl;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * This class includes the tests for travelManagerFactory class.
 */
public class TravelManagerFactoryTest {
    @Test
    public void testGetTravelManager() {
        assertTrue(TravelManagerFactory.getTravelManager() instanceof TravelManagerImpl);
    }
}
