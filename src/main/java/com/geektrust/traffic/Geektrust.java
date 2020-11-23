package com.geektrust.traffic;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geektrust.traffic.enums.Weather;
import com.geektrust.traffic.exceptions.FilePathException;
import com.geektrust.traffic.exceptions.InvalidTrafficSpeedException;
import com.geektrust.traffic.exceptions.InvalidWeatherException;
import com.geektrust.traffic.model.Orbit;
import com.geektrust.traffic.model.OrbitVehicle;
import com.geektrust.traffic.model.TravelOption;
import com.geektrust.traffic.model.WeatherCondition;
import com.geektrust.traffic.travelmanager.TravelManager;
import com.geektrust.traffic.travelmanager.TravelManagerFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * This Application aims to solve the problem of traffic in a distant planet
 * called Lengaburu, it would provide King Shan with the best possible option to
 * travel from point A to point B. An input with current weather and the traffic
 * speed on the routes availabe is needed.
 */
public class Geektrust {

    private static TravelManager travelManager;
    private static ObjectMapper objectMapper = new ObjectMapper();

    protected Geektrust() {
    }

    /**
     * This methode prints the travel option on the console.
     */
    public static void printTravelOption(TravelOption traveloption) {
        System.out.println(traveloption.getVehicle().toUpperCase() + " " + traveloption.getOrbit().toUpperCase());
    }

    private static BufferedReader resolveFileFromResources(String fileName)
            throws FileNotFoundException, URISyntaxException {
        InputStream inputStream = Geektrust.class.getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        return br;
    }

    /**
     * This method reads the vehicle specifications file
     * and maps the data to an array of vehicle objects.
     * @return OrbitVehicle[]
    */
    private static OrbitVehicle[] getVehicles()
            throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
        OrbitVehicle[] vehicles = objectMapper
            .readValue(resolveFileFromResources("/vehicleSpec.json"),
                OrbitVehicle[].class);
        return vehicles;
    }

    /**
     * This method reads the orbit specification file
     *  and maps the data to an array of orbit objects.
     * @return Orbit[]
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     * @throws URISyntaxException
     */
    private static Orbit[] getOrbits() throws JsonParseException, JsonMappingException,
        IOException, URISyntaxException {
        Orbit[] orbits = objectMapper
            .readValue(resolveFileFromResources("/orbitSpec.json"),
                Orbit[].class);
        return orbits;
    }

    /**
     * This method reads the weather conditions specification file
     *  and maps the data to an array of weatherCondition objects.
     * @return WeatherCondition[]
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     * @throws URISyntaxException
     */
    private static WeatherCondition[] getWeatherConditions()
            throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
        WeatherCondition[] weatherConditions = objectMapper
            .readValue(resolveFileFromResources("/weatherConditionSpec.json"),
                WeatherCondition[].class);
        return weatherConditions;
    }

    /**
     * This method reads the input file from the path provided in the command line
     * arguments.
     * 
     * @return String[]
     * @throws FilePathException
     */
    public static String[] readInputFile(String filePath) throws URISyntaxException, IOException, FilePathException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new FilePathException("Unable to find the input file in the specified path.");
        }
        String firstLine = reader.readLine();
        reader.close();
        String[] file = firstLine.split(" ");
        return file;
    }

    /**
     * This method retreieves the best travel option using TravelManagerFactory.
     * 
     * @return A TravelOption object.
     * @throws InvalidWeatherException
     * @throws InvalidTrafficSpeedException
     */
    public static TravelOption getTravelOption(String[] inputFile) throws JsonParseException, JsonMappingException,
            IOException, URISyntaxException, InvalidWeatherException, InvalidTrafficSpeedException {
        Weather weather;
        try {
            weather = Weather.valueOf(inputFile[0]);
        } catch (IllegalArgumentException e) {
            throw new InvalidWeatherException();
        }
        WeatherCondition[] weatherConditions = getWeatherConditions();
        WeatherCondition weatherCondition = Arrays
            .stream(weatherConditions).filter(w
                -> w.getWeather().equals(weather)).findFirst().orElse(null);
        OrbitVehicle[] vehicles = getVehicles();
        Orbit[] orbits = getOrbits();
        for (int i = 0; i < orbits.length; i++) {
            if(Integer.parseInt(inputFile[i + 1]) > 0) {
                orbits[i].setTrafficSpeed(Integer.parseInt(inputFile[i + 1]));
            } else {
                throw new InvalidTrafficSpeedException();
            }
        }
        travelManager = TravelManagerFactory.getTravelManager();
        TravelOption travelOption = travelManager.getBestTravelOption(weatherCondition, vehicles, orbits);
        return travelOption;
    }

    /**
     * This is the main method which uses getTravelOption and printTravelOption to
     * get the best travel option and to print it on the console.
     * 
     * @throws InvalidTrafficSpeedException
     */
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException,
            URISyntaxException, InvalidWeatherException, FilePathException, InvalidTrafficSpeedException {
        try {
            printTravelOption(getTravelOption(readInputFile(args[0])));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new FilePathException();
        }
    }
}
