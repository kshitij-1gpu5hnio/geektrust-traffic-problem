package com.geektrust.traffic;

import com.geektrust.traffic.model.TravelOption;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.geektrust.traffic.exceptions.InvalidTrafficSpeedException;
import com.geektrust.traffic.exceptions.InvalidWeatherException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class includes tests for the geektrust application.
 */
public class GeektrustIntegrationTest {

    private Geektrust geektrust = new Geektrust();

    @Test
    public void testGetTravelOptionWhenWeatherIsRainyWithTrafficSpeeds8and15()
            throws URISyntaxException, IOException, InvalidWeatherException, InvalidTrafficSpeedException {
        String[] input = { "RAINY", "8", "15" };
        TravelOption actualTravelOption = geektrust.getTravelOption(input);
        TravelOption expectedTravelOption = new TravelOption("tuktuk", "ORBIT2", 112);

        assertEquals(expectedTravelOption, actualTravelOption);
    }

    @Test
    public void testGetTravelOptionWhenWeatherIsWindyWithTrafficSpeeds14and20()
            throws URISyntaxException, IOException, InvalidWeatherException, InvalidTrafficSpeedException {
        String[] input = { "WINDY", "14", "20" };
        TravelOption actualTravelOption = geektrust.getTravelOption(input);
        TravelOption expectedTravelOption = new TravelOption("car", "ORBIT2", 90);

        assertEquals(expectedTravelOption, actualTravelOption);
    }

    @Test
    public void testGetTravelOptionWhenWeatherIsSunnyWithTrafficSpeeds12and10()
            throws URISyntaxException, IOException, InvalidWeatherException, InvalidTrafficSpeedException {
        String[] input = { "SUNNY", "12", "10" };
        TravelOption actualTravelOption = geektrust.getTravelOption(input);
        TravelOption expectedTravelOption = new TravelOption("tuktuk", "ORBIT1", 108);

        assertEquals(expectedTravelOption, actualTravelOption);
    }

    @Test(expected = InvalidWeatherException.class)
    public void testGetTravelOptionThrowsInvalidWeatherException() throws JsonParseException, JsonMappingException, IOException,
            URISyntaxException, InvalidWeatherException, InvalidTrafficSpeedException {
        String[] input = { "SUMMER", "12", "10" };
        geektrust.getTravelOption(input);
    }

    @Test(expected = InvalidTrafficSpeedException.class)
    public void testGetTravelOptionThrowsInvalidTrafficSpeedException() throws JsonParseException, JsonMappingException, IOException,
            URISyntaxException, InvalidWeatherException, InvalidTrafficSpeedException {
        String[] input = { "SUNNY", "0", "10" };
        geektrust.getTravelOption(input);
    }
}
